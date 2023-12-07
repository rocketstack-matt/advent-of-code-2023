package aoc.day7;

public enum Card {
  ACE(14),
  KING(13),
  QUEEN(12),
  JACK(11),
  TEN(10),
  NINE(9),
  EIGHT(8),
  SEVEN(7),
  SIX(6),
  FIVE(5),
  FOUR(4),
  THREE(3),
  TWO(2);

  final int value;

  Card(int value) {
    this.value = value;
  }

  boolean greaterThan(Card other) {
    return this.value > other.value;
  }

  public static Card cardFromCode(String cardCode) {
    return switch (cardCode) {
      case "A" -> Card.ACE;
      case "K" -> Card.KING;
      case "Q" -> Card.QUEEN;
      case "J" -> Card.JACK;
      case "T" -> Card.TEN;
      case "9" -> Card.NINE;
      case "8" -> Card.EIGHT;
      case "7" -> Card.SEVEN;
      case "6" -> Card.SIX;
      case "5" -> Card.FIVE;
      case "4" -> Card.FOUR;
      case "3" -> Card.THREE;
      case "2" -> Card.TWO;
      default -> null;
    };
  }
}
