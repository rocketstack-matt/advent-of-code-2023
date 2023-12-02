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

  @Test
  void game_id_1_has_power_of_min_cubes_48() {
    Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    Assertions.assertEquals(48, game.powerOfMinCubes());
  }

  @Test
  void game_id_2_has_power_of_min_cubes_12() {
    Game game = new Game("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
    Assertions.assertEquals(12, game.powerOfMinCubes());
  }

  @Test
  void game_id_3_has_power_of_min_cubes_1560() {
    Game game =
        new Game("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
    Assertions.assertEquals(1560, game.powerOfMinCubes());
  }

  @Test
  void game_id_4_has_power_of_min_cubes_630() {
    Game game =
        new Game("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
    Assertions.assertEquals(630, game.powerOfMinCubes());
  }

  @Test
  void game_id_5_has_power_of_min_cubes_36() {
    Game game = new Game("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");
    Assertions.assertEquals(36, game.powerOfMinCubes());
  }
}
