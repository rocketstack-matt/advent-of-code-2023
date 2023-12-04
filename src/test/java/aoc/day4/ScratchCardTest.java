package aoc.day4;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScratchCardTest {
    @Test
    void when_a_card_has_the_same_number_as_a_winning_number_then_it_is_a_winner() {
        ScratchCard scratchCard = new ScratchCard(1, List.of(41, 48, 83, 86, 17),
                List.of(83, 86, 6, 31, 17, 9, 48, 53));
        Assertions.assertTrue(scratchCard.isWinner());
    }

    @Test
    void when_a_card_is_loaded_from_a_string_then_it_contains_the_expected_card_number() {
        ScratchCard scratchCard = new ScratchCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        Assertions.assertEquals(1, scratchCard.cardNo);
    }

    @Test
    void when_a_card_is_loaded_from_a_string_then_it_contains_the_expected_numbers() {
        ScratchCard scratchCard = new ScratchCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        Assertions.assertEquals(List.of(41, 48, 83, 86, 17), scratchCard.winningNumbers);
        Assertions.assertEquals(List.of(83, 86, 6, 31, 17, 9, 48, 53), scratchCard.cardNumbers);
    }

    @Test
    void value_of_scratch_card_1_is_8() {
        ScratchCard scratchCard = new ScratchCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        Assertions.assertEquals(8, scratchCard.cardValue());
    }

    @Test
    void value_of_scratch_card_2_is_2() {
        ScratchCard scratchCard = new ScratchCard("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");
        Assertions.assertEquals(2, scratchCard.cardValue());
    }

    @Test
    void value_of_scratch_card_3_is_2() {
        ScratchCard scratchCard = new ScratchCard("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1");
        Assertions.assertEquals(2, scratchCard.cardValue());
    }

    @Test
    void value_of_scratch_card_4_is_1() {
        ScratchCard scratchCard = new ScratchCard("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83");
        Assertions.assertEquals(1, scratchCard.cardValue());
    }

    @Test
    void value_of_scratch_card_5_is_0() {
        ScratchCard scratchCard = new ScratchCard("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36");
        Assertions.assertEquals(0, scratchCard.cardValue());
    }

    @Test
    void value_of_scratch_card_6_is_0() {
        ScratchCard scratchCard = new ScratchCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");
        Assertions.assertEquals(0, scratchCard.cardValue());
    }

    @Test
    void card_1_has_4_winners() {
        ScratchCard scratchCard = new ScratchCard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        Assertions.assertEquals(4, scratchCard.winners());
    }

    @Test
    void card_2_has_2_winners() {
        ScratchCard scratchCard = new ScratchCard("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");
        Assertions.assertEquals(2, scratchCard.winners());
    }

    @Test
    void card_3_has_2_winners() {
        ScratchCard scratchCard = new ScratchCard("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1");
        Assertions.assertEquals(2, scratchCard.winners());
    }

    @Test
    void card_4_has_1_winner() {
        ScratchCard scratchCard = new ScratchCard("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83");
        Assertions.assertEquals(1, scratchCard.winners());
    }

    @Test
    void card_5_has_0_winners() {
        ScratchCard scratchCard = new ScratchCard("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36");
        Assertions.assertEquals(0, scratchCard.winners());
    }

    @Test
    void card_6_has_0_winners() {
        ScratchCard scratchCard = new ScratchCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");
        Assertions.assertEquals(0, scratchCard.winners());
    }
}
