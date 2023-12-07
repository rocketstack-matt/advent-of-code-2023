package aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
  @Test
  void card_code_A_should_be_14() {
    Card card = Card.cardFromCode("A");
    Assertions.assertEquals(14, card.value);
  }

  @Test
  void card_code_K_should_be_13() {
    Card card = Card.cardFromCode("K");
    Assertions.assertEquals(13, card.value);
  }

  @Test
  void card_code_Q_should_be_12() {
    Card card = Card.cardFromCode("Q");
    Assertions.assertEquals(12, card.value);
  }

  @Test
  void card_code_J_should_be_11() {
    Card card = Card.cardFromCode("J");
    Assertions.assertEquals(11, card.value);
  }

  @Test
  void card_code_T_should_be_10() {
    Card card = Card.cardFromCode("T");
    Assertions.assertEquals(10, card.value);
  }

  @Test
  void card_code_9_should_be_9() {
    Card card = Card.cardFromCode("9");
    Assertions.assertEquals(9, card.value);
  }

  @Test
  void card_code_8_should_be_8() {
    Card card = Card.cardFromCode("8");
    Assertions.assertEquals(8, card.value);
  }

  @Test
  void card_code_7_should_be_7() {
    Card card = Card.cardFromCode("7");
    Assertions.assertEquals(7, card.value);
  }

  @Test
  void card_code_6_should_be_6() {
    Card card = Card.cardFromCode("6");
    Assertions.assertEquals(6, card.value);
  }

  @Test
  void card_code_5_should_be_5() {
    Card card = Card.cardFromCode("5");
    Assertions.assertEquals(5, card.value);
  }

  @Test
  void card_code_4_should_be_4() {
    Card card = Card.cardFromCode("4");
    Assertions.assertEquals(4, card.value);
  }

  @Test
  void card_code_3_should_be_3() {
    Card card = Card.cardFromCode("3");
    Assertions.assertEquals(3, card.value);
  }

  @Test
  void card_code_2_should_be_2() {
    Card card = Card.cardFromCode("2");
    Assertions.assertEquals(2, card.value);
  }
}
