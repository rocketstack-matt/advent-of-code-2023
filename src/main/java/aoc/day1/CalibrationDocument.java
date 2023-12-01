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

  public int rowCalibrationValue(String calibrationInput) {
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
}
