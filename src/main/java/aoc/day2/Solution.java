package aoc.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

  private final int resultForValidGames;
  private final int resultForPowerOfAllPossibleGames;

  public Solution() throws FileNotFoundException {
    String filepath = Objects.requireNonNull(getClass().getResource("day2.input")).getFile();
    Scanner scanner = new Scanner(new File(filepath));

    StringBuilder gameInput = new StringBuilder();
    while (scanner.hasNextLine()) {
      gameInput.append(scanner.nextLine()).append("\n");
    }

    Bag bag = new Bag(12, 14, 13);
    resultForValidGames = bag.sumOfValidGames(gameInput.toString());
    resultForPowerOfAllPossibleGames = bag.sumOfPowerOfAllPossibleGames(gameInput.toString());
  }

  public static void main(String[] args) throws FileNotFoundException {
    Solution solution = new Solution();
    System.out.println("Part 1: " + solution.resultForValidGames);
    System.out.println("Part 2: " + solution.resultForPowerOfAllPossibleGames);
  }
}
