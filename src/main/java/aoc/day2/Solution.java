package aoc.day2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

  private int result;
  
  public Solution() throws FileNotFoundException {
    String filepath = Objects.requireNonNull(getClass().getResource("day2.input")).getFile();
    Scanner scanner = new Scanner(new File(filepath));

    StringBuilder gameInput= new StringBuilder();
    while(scanner.hasNextLine()) {
      gameInput.append(scanner.nextLine()).append("\n");
    }

    Bag bag = new Bag(12, 14, 13);
    result = bag.sumOfValidGames(gameInput.toString());
  }

  public static void main(String[] args) throws FileNotFoundException {
    Solution solution = new Solution();
    System.out.println(solution.result);
  }
}
