package aoc.day1;

import java.io.FileNotFoundException;

public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    CalibrationDocument document = new CalibrationDocument("day1.input");
    System.out.println("Part 1: " + document.totalCalibrationDocumentValue());
    System.out.println("Part 2: " + document.totalCalibrationDocumentValueWithNumericWords());
  }
}
