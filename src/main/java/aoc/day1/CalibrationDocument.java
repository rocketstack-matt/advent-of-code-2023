package aoc.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CalibrationDocument {
  final List<String> calibrationDocument;

  public CalibrationDocument(List<String> calibrationDocument) {
    this.calibrationDocument = calibrationDocument;
  }

  public CalibrationDocument(String filename) throws FileNotFoundException, NullPointerException {
    String filepath = Objects.requireNonNull(getClass().getResource(filename)).getFile();
    calibrationDocument = new ArrayList<>();

    Scanner scanner = new Scanner(new File(filepath));
    while (scanner.hasNextLine()) {
      calibrationDocument.add(scanner.nextLine());
    }
  }

  int rowCalibrationValue(String calibrationInput) {
    String digits =
        calibrationInput
            .chars()
            .filter(Character::isDigit)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    StringBuilder firstAndLast = new StringBuilder();
    firstAndLast
        .appendCodePoint(digits.codePointAt(0))
        .appendCodePoint(digits.codePointAt(digits.length() - 1));
    return Integer.parseInt(firstAndLast.toString());
  }

  public int totalCalibrationDocumentValue() {
    int total = 0;
    for (String calibrationInput : this.calibrationDocument) {
      total += rowCalibrationValue(calibrationInput);
    }
    return total;
  }

  public int totalCalibrationDocumentValueWithNumericWords() {
    int total = 0;
    for (String calibrationInput : this.calibrationDocument) {
      total += rowCalibrationValue(convertNumericWordsToDigits(calibrationInput));
    }
    return total;
  }

  String convertNumericWordsToDigits(String calibrationInput) {
    return calibrationInput
        .replaceAll("oneight", "18")
        .replaceAll("twone", "21")
        .replaceAll("eightwo", "82")
        .replaceAll("one", "1")
        .replaceAll("two", "2")
        .replaceAll("three", "3")
        .replaceAll("four", "4")
        .replaceAll("five", "5")
        .replaceAll("six", "6")
        .replaceAll("seven", "7")
        .replaceAll("eight", "8")
        .replaceAll("nine", "9")
        .replaceAll("zero", "0");
  }
}
