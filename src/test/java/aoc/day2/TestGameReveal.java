package aoc.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGameReveal {
    @Test
    void game_reveal_loads_from_record_segment_with_1_part() {
        GameReveal reveal = new GameReveal("2 green");
        Assertions.assertEquals(2, reveal.green());
    }

    @Test
    void game_reveal_loads_from_record_segment_with_2_parts() {
        GameReveal reveal = new GameReveal("3 blue, 4 red");
        Assertions.assertEquals(3, reveal.blue());
        Assertions.assertEquals(4, reveal.red());
    }

    @Test
    void game_reveal_loads_from_record_segment_with_3_parts() {
        GameReveal reveal = new GameReveal("1 red, 2 green, 6 blue");
        Assertions.assertEquals(1, reveal.red());
        Assertions.assertEquals(2, reveal.green());
        Assertions.assertEquals(6, reveal.blue());
    }

}