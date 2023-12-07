package aoc.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CamelCards {
  List<Hand> hands = new ArrayList<>();

  public CamelCards() {
    // For Tests.
  }

  public CamelCards(String filename) throws FileNotFoundException {
    String filepath = Objects.requireNonNull(getClass().getResource(filename)).getFile();
    Scanner scanner = new Scanner(new File(filepath));

    while (scanner.hasNextLine()) {
      addHand(scanner.nextLine());
    }
  }

  public Hand addHand(String input) {
    hands.add(Hand.handWithBid(input));
    return hands.get(hands.size() - 1);
  }

  public void rankHands() {
    Collections.sort(hands);
  }

  public int getRank(Hand hand) {
    return hands.indexOf(hand) + 1;
  }

  public int calculateWinnings() {
    rankHands();

    int totalScore = 0;
    for (Hand hand : hands) {
      totalScore += hand.bid * getRank(hand);
    }
    return totalScore;
  }

  public static void main(String[] args) throws FileNotFoundException {
    CamelCards camelCards = new CamelCards("day7.input");
    System.out.println("Part 1: " + camelCards.calculateWinnings());
  }
}
