package aoc.day1;

import java.io.FileNotFoundException;

public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    CalibrationDocument document = new CalibrationDocument("test.input");
    System.out.println(document.totalCalibrationDocumentValue());
  }
}
