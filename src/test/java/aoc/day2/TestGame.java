package aoc.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {
  @Test
  void game_id_1_has_id_1() {
    Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    Assertions.assertEquals(1, game.id());
  }

  @Test
  void game_id_1_has_3_game_reveals() {
    Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    Assertions.assertEquals(3, game.reveals().size());
  }

  @Test
  void game_id_1_contains_reveal_with_3_blue_3_red() {
    Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    Assertions.assertEquals(3, game.reveals().get(0).blue());
    Assertions.assertEquals(4, game.reveals().get(0).red());
  }

  @Test
  void game_id_1_contains_reveal_with_1_red_2_green_6_blue() {
    Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    Assertions.assertEquals(1, game.reveals().get(1).red());
    Assertions.assertEquals(2, game.reveals().get(1).green());
    Assertions.assertEquals(6, game.reveals().get(1).blue());
  }

  @Test
  void game_id_1_contains_reveal_with_2_gree() {
    Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    Assertions.assertEquals(2, game.reveals().get(2).green());
  }
}
