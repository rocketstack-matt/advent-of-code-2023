package aoc.day3;

import java.io.FileNotFoundException;

public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    Engine engine = new Engine("day3.input");
    System.out.println("Part 1: " + engine.sumOfAllValidEngineParts());
  }
}
