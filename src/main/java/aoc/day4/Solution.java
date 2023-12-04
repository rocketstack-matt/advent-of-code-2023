package aoc.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

  int totalPoints = 0;

  public Solution() throws FileNotFoundException {
    String filepath = Objects.requireNonNull(getClass().getResource("day4.input")).getFile();
    Scanner scanner = new Scanner(new File(filepath));

    while (scanner.hasNextLine()) {
      ScratchCard scratchCard = new ScratchCard(scanner.nextLine());
      totalPoints += scratchCard.cardValue();
    }

  }

  public static void main(String[] args) throws FileNotFoundException {
    Solution solution = new Solution();
    System.out.println("Part 1: " + solution.totalPoints);
  }
}
