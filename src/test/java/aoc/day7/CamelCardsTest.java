package aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CamelCardsTest {

  @Test
  void check_camel_card_order_matches_input() {
    CamelCards camelCards = new CamelCards();
    camelCards.addHand("32T3K 765");
    camelCards.addHand("T55J5 684");
    camelCards.addHand("KK677 28");
    camelCards.addHand("KTJJT 220");
    camelCards.addHand("QQQJA 483");

    Assertions.assertEquals(765, camelCards.hands.get(0).bid);
    Assertions.assertEquals(Card.THREE, camelCards.hands.get(0).cards.get(0));
    Assertions.assertEquals(Card.TWO, camelCards.hands.get(0).cards.get(1));
    Assertions.assertEquals(Card.TEN, camelCards.hands.get(0).cards.get(2));
    Assertions.assertEquals(Card.THREE, camelCards.hands.get(0).cards.get(3));
    Assertions.assertEquals(Card.KING, camelCards.hands.get(0).cards.get(4));

    Assertions.assertEquals(483, camelCards.hands.get(4).bid);
    Assertions.assertEquals(Card.QUEEN, camelCards.hands.get(4).cards.get(0));
    Assertions.assertEquals(Card.QUEEN, camelCards.hands.get(4).cards.get(1));
    Assertions.assertEquals(Card.QUEEN, camelCards.hands.get(4).cards.get(2));
    Assertions.assertEquals(Card.JACK, camelCards.hands.get(4).cards.get(3));
    Assertions.assertEquals(Card.ACE, camelCards.hands.get(4).cards.get(4));
  }

  @Test
  void check_hands_by_rank() {
    CamelCards camelCards = new CamelCards();
    Hand hand1 = camelCards.addHand("32T3K 765");
    Hand hand2 = camelCards.addHand("T55J5 684");
    Hand hand3 = camelCards.addHand("KK677 28");
    Hand hand4 = camelCards.addHand("KTJJT 220");
    Hand hand5 = camelCards.addHand("QQQJA 483");

    Assertions.assertEquals(1, camelCards.getRank(hand1));
    Assertions.assertEquals(2, camelCards.getRank(hand2));
    Assertions.assertEquals(3, camelCards.getRank(hand3));
    Assertions.assertEquals(4, camelCards.getRank(hand4));
    Assertions.assertEquals(5, camelCards.getRank(hand5));

    camelCards.rankHands();

    Assertions.assertEquals(1, camelCards.getRank(hand1));
    Assertions.assertEquals(2, camelCards.getRank(hand4));
    Assertions.assertEquals(3, camelCards.getRank(hand3));
    Assertions.assertEquals(4, camelCards.getRank(hand2));
    Assertions.assertEquals(5, camelCards.getRank(hand5));
  }

  @Test
  void total_winning_equals_6440() {
    CamelCards camelCards = new CamelCards();
    camelCards.addHand("32T3K 765");
    camelCards.addHand("T55J5 684");
    camelCards.addHand("KK677 28");
    camelCards.addHand("KTJJT 220");
    camelCards.addHand("QQQJA 483");
    Assertions.assertEquals(6440, camelCards.calculateWinnings());
  }
}
