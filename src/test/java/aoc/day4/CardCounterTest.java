package aoc.day4;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardCounterTest {
    @Test
    void cardCounter_has_one_of_each_card_load_on_init() throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(cardCounter.scratchCards.keySet(), Set.of(1, 2, 3, 4, 5, 6));

        Map<Integer, Integer> scratchCardCounts = cardCounter.scratchCardCounts();
        for (Integer cardNo : scratchCardCounts.keySet()) {
            System.out.println(cardNo + " " + scratchCardCounts.get(cardNo));
        }

        System.out.println(cardCounter.totalCardCount());
    }

    @Test
    void cardCounter_has_1_instance_of_card_1()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(1, cardCounter.scratchCardCounts().get(1));
    }

    @Test
    void cardCounter_has_2_instances_of_card_2()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(2, cardCounter.scratchCardCounts().get(2));
    }

    @Test
    void cardCounter_has_4_instances_of_card_3()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(4, cardCounter.scratchCardCounts().get(3));
    }

    @Test
    void cardCounter_has_8_instance_of_card_4()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(8, cardCounter.scratchCardCounts().get(4));
    }

    @Test
    void cardCounter_has_14_instances_of_card_5()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(14, cardCounter.scratchCardCounts().get(5));
    }

    @Test
    void cardCounter_has_1_instance_of_card_6()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(1, cardCounter.scratchCardCounts().get(6));
    }

    @Test
    void cardCounter_has_30_cards_in_total()
            throws FileNotFoundException {
        CardCounter cardCounter = new CardCounter("test.input");
        Assertions.assertEquals(30, cardCounter.totalCardCount());
    }

}
