package aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HandTest {
  @Test
  void hand_from_32T3K_first_card_is_3() {
    Hand hand = new Hand("32T3K");
    Assertions.assertEquals(Card.THREE, hand.cards.get(0));
  }

  @Test
  void hand_from_32T3K_second_card_is_2() {
    Hand hand = new Hand("32T3K");
    Assertions.assertEquals(Card.TWO, hand.cards.get(1));
  }

  @Test
  void hand_from_32T3K_third_card_is_T() {
    Hand hand = new Hand("32T3K");
    Assertions.assertEquals(Card.TEN, hand.cards.get(2));
  }

  @Test
  void hand_from_32T3K_fourth_card_is_3() {
    Hand hand = new Hand("32T3K");
    Assertions.assertEquals(Card.THREE, hand.cards.get(3));
  }

  @Test
  void hand_from_32T3K_fifth_card_is_K() {
    Hand hand = new Hand("32T3K");
    Assertions.assertEquals(Card.KING, hand.cards.get(4));
  }

  @Test
  void hand_from_32T3K_is_equal_to_hand_from_32T3K() {
    Hand hand1 = new Hand("32T3K");
    Hand hand2 = new Hand("32T3K");
    Assertions.assertEquals(hand1, hand2);
  }

  @Test
  void hand_from_32T3K_is_not_equal_to_hand_from_32T3Q() {
    Hand hand1 = new Hand("32T3K");
    Hand hand2 = new Hand("32T3Q");
    Assertions.assertNotEquals(hand1, hand2);
  }

  @Test
  void hand_is_five_of_a_kind() {
    Hand hand = new Hand("AAAAA");
    Assertions.assertTrue(hand.isFiveOfAKind());
  }

  @Test
  void hand_is_not_five_of_a_kind() {
    Hand hand = new Hand("AAAAK");
    Assertions.assertFalse(hand.isFiveOfAKind());
  }

  @Test
  void hand_is_four_of_a_kind() {
    Hand hand = new Hand("AAAAK");
    Assertions.assertTrue(hand.isFourOfAKind());
  }

  @Test
  void hand_is_also_four_of_a_kind() {
    Hand hand = new Hand("KKKKA");
    Assertions.assertTrue(hand.isFourOfAKind());
  }

  @Test
  void hand_is_yet_again_four_of_a_kind() {
    Hand hand = new Hand("KKAKK");
    Assertions.assertTrue(hand.isFourOfAKind());
  }

  @Test
  void hand_is_not_four_of_a_kind() {
    Hand hand = new Hand("KKAKQ");
    Assertions.assertFalse(hand.isFourOfAKind());
  }

  @Test
  void hand_is_not_four_of_a_kind_either() {
    Hand hand = new Hand("AAAAA");
    Assertions.assertFalse(hand.isFourOfAKind());
  }

  @Test
  void hand_is_three_of_a_kind() {
    Hand hand = new Hand("AAA23");
    Assertions.assertTrue(hand.isThreeOfAKind());
  }

  @Test
  void hand_is_also_three_of_a_kind() {
    Hand hand = new Hand("AA2A3");
    Assertions.assertTrue(hand.isThreeOfAKind());
  }

  @Test
  void hand_is_not_three_of_a_kind() {
    Hand hand = new Hand("AA2Q4");
    Assertions.assertFalse(hand.isThreeOfAKind());
  }

  @Test
  void hand_is_two_pair() {
    Hand hand = new Hand("AA223");
    Assertions.assertTrue(hand.isTwoPair());
  }

  @Test
  void hand_is_not_two_pair() {
    Hand hand = new Hand("AA2Q4");
    Assertions.assertFalse(hand.isTwoPair());
  }

  @Test
  void hand_is_pair() {
    Hand hand = new Hand("AA234");
    Assertions.assertTrue(hand.isPair());
  }

  @Test
  void hand_is_not_pair() {
    Hand hand = new Hand("AA2A4");
    Assertions.assertFalse(hand.isPair());
  }

  @Test
  void hand_is_not_pair_either() {
    Hand hand = new Hand("AA2AA");
    Assertions.assertFalse(hand.isPair());
  }

  @Test
  void hand_is_full_house() {
    Hand hand = new Hand("AAAKK");
    Assertions.assertTrue(hand.isFullHouse());
  }

  @Test
  void hand_is_also_full_house() {
    Hand hand = new Hand("KKAAA");
    Assertions.assertTrue(hand.isFullHouse());
  }

  @Test
  void hand_is_not_full_house() {
    Hand hand = new Hand("AAAKQ");
    Assertions.assertFalse(hand.isFullHouse());
  }

  @Test
  void hand_is_high_card() {
    Hand hand = new Hand("AKQJT");
    Assertions.assertTrue(hand.isHighCard());
  }

  @Test
  void hand_is_not_high_card() {
    Hand hand = new Hand("AAQJ9");
    Assertions.assertFalse(hand.isHighCard());
  }

  @Test
  void given_two_hands_33332_and_2AAAA_33332_is_stronger() {
    Hand hand1 = new Hand("33332");
    Hand hand2 = new Hand("2AAAA");
    Assertions.assertEquals(1, hand1.compareTo(hand2));
  }

  @Test
  void given_two_hands_77888_and_77788_77888_is_stronger() {
    Hand hand1 = new Hand("77888");
    Hand hand2 = new Hand("77788");
    Assertions.assertEquals(1, hand1.compareTo(hand2));
  }
}
