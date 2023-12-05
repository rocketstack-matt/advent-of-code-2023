package aoc.day5;

import java.io.FileNotFoundException;

public class Solution {

  public static void main(String[] args) throws FileNotFoundException {
    Almanac almanac = new Almanac("day5.input");
    System.out.println("Part 1: " + almanac.getClosestLocation());
  }
}
