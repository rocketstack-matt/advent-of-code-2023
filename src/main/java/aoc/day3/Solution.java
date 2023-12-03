package aoc.day3;


public class Solution {
  public static void main(String[] args) throws Exception {
    Engine engine = new Engine("day3.input");
    System.out.println("Part 1: " + engine.sumOfAllValidEngineParts());
    System.out.println("Part 2: " + engine.sumOfAllGearRatios());
  }
}
