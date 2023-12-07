package aoc.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class Hand implements Comparable<Hand> {
  List<Card> cards = new ArrayList<>();
  int bid;

  public Hand(String hand) {
    for (Character cardCode : hand.toCharArray()) {
      cards.add(Card.cardFromCode(cardCode.toString()));
    }
  }

  public static Hand handWithBid(String hand) {
    String[] tokens = hand.split(" ");
    Hand handWithBid = new Hand(tokens[0]);
    handWithBid.bid = Integer.parseInt(tokens[1]);
    return handWithBid;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Hand other)) {
      return false;
    }

    for (int i = 0; i < cards.size(); i++) {
      if (!cards.get(i).equals(other.cards.get(i))) {
        return false;
      }
    }
    return true;
  }

  public boolean isFiveOfAKind() {
    return cards.stream().allMatch(card -> card.equals(cards.get(0)));
  }

  public boolean isFourOfAKind() {
    return cards.stream().filter(card -> card.equals(cards.get(0))).count() == 4
        || cards.stream().filter(card -> card.equals(cards.get(1))).count() == 4;
  }

  public boolean isThreeOfAKind() {
    return cards.stream().filter(card -> card.equals(cards.get(0))).count() == 3
        || cards.stream().filter(card -> card.equals(cards.get(1))).count() == 3
        || cards.stream().filter(card -> card.equals(cards.get(2))).count() == 3;
  }

  public boolean isTwoPair() {
    Set<Card> matchedCards = new HashSet<>();
    if (cards.stream().filter(card -> card.equals(cards.get(0))).count() == 2)
        matchedCards.add(cards.get(0));
    if (cards.stream().filter(card -> card.equals(cards.get(1))).count() == 2)
      matchedCards.add(cards.get(1));
    if (cards.stream().filter(card -> card.equals(cards.get(2))).count() == 2)
        matchedCards.add(cards.get(2));
    if (cards.stream().filter(card -> card.equals(cards.get(3))).count() == 2)
        matchedCards.add(cards.get(3));
    if (cards.stream().filter(card -> card.equals(cards.get(4))).count() == 2)
        matchedCards.add(cards.get(4));
    return matchedCards.size() == 2;
  }

  public boolean isPair() {
    return cards.stream().filter(card -> card.equals(cards.get(0))).count() == 2
        || cards.stream().filter(card -> card.equals(cards.get(1))).count() == 2
        || cards.stream().filter(card -> card.equals(cards.get(2))).count() == 2
        || cards.stream().filter(card -> card.equals(cards.get(3))).count() == 2
        || cards.stream().filter(card -> card.equals(cards.get(4))).count() == 2;
  }

  public boolean isFullHouse() {
    return isThreeOfAKind() && isPair();
  }

  public boolean isHighCard() {
    return !isFiveOfAKind() && !isFourOfAKind() && !isThreeOfAKind() && !isTwoPair() && !isPair();
  }

  @Override
  public int compareTo(@NotNull Hand o) {
    if (isFiveOfAKind() && !o.isFiveOfAKind()) {
      return 1;
    }

    if (!isFiveOfAKind() && o.isFiveOfAKind()) {
      return -1;
    }

    if (isFourOfAKind() && !o.isFourOfAKind()) {
      return 1;
    }

    if (!isFourOfAKind() && o.isFourOfAKind()) {
      return -1;
    }

    if (isFullHouse() && !o.isFullHouse()) {
      return 1;
    }

    if (!isFullHouse() && o.isFullHouse()) {
      return -1;
    }

    if (isThreeOfAKind() && !o.isThreeOfAKind()) {
      return 1;
    }

    if (!isThreeOfAKind() && o.isThreeOfAKind()) {
      return -1;
    }

    if (isTwoPair() && !o.isTwoPair()) {
      return 1;
    }

    if (!isTwoPair() && o.isTwoPair()) {
      return -1;
    }

    if (isPair() && !o.isPair()) {
      return 1;
    }

    if (!isPair() && o.isPair()) {
      return -1;
    }

    for (int i = 0; i < cards.size(); i++) {
      if (cards.get(i).greaterThan(o.cards.get(i))) {
        return 1;
      }

      if (o.cards.get(i).greaterThan(cards.get(i))) {
        return -1;
      }
    }

    return 0;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Card card : cards) {
      switch (card) {
        case ACE -> stringBuilder.append("A");
        case KING -> stringBuilder.append("K");
        case QUEEN -> stringBuilder.append("Q");
        case JACK -> stringBuilder.append("J");
        case TEN -> stringBuilder.append("T");
        case NINE -> stringBuilder.append("9");
        case EIGHT -> stringBuilder.append("8");
        case SEVEN -> stringBuilder.append("7");
        case SIX -> stringBuilder.append("6");
        case FIVE -> stringBuilder.append("5");
        case FOUR -> stringBuilder.append("4");
        case THREE -> stringBuilder.append("3");
        case TWO -> stringBuilder.append("2");
      }
    }
    return stringBuilder.toString();
  }
}
