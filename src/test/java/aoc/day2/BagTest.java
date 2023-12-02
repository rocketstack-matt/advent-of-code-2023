package aoc.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagTest {
  @Test
  void game_1_is_valid_for_bag_with_12_red_13_green_and_14_blue_cubes() {
    Bag bag = new Bag(12, 13, 14);
    Assertions.assertTrue(bag.validGame("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
  }

  @Test
  void game_2_is_valid_for_bag_with_12_red_13_green_and_14_blue_cubes() {
    Bag bag = new Bag(12, 13, 14);
    Assertions.assertTrue(
        bag.validGame("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
  }

  @Test
  void game_3_is_invalid_for_bag_with_12_red_13_green_and_14_blue_cubes() {
    Bag bag = new Bag(12, 13, 14);
    Assertions.assertFalse(
        bag.validGame("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
  }

  @Test
  void game_4_is_invalid_for_bag_with_12_red_13_green_and_14_blue_cubes() {
    Bag bag = new Bag(12, 13, 14);
    Assertions.assertFalse(
        bag.validGame("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
  }

  @Test
  void game_5_is_valid_for_bag_with_12_red_13_green_and_14_blue_cubes() {
    Bag bag = new Bag(12, 13, 14);
    Assertions.assertTrue(bag.validGame("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
  }

  @Test
  void id_sum_for_all_valid_games_is_8() {
    Bag bag = new Bag(12, 13, 14);
    Assertions.assertEquals(
        8,
        bag.sumOfValidGames(
            """
                        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"""));
  }

  @Test
  void power_sum_for_all_games_is_2286() {
    Bag bag = new Bag();
    Assertions.assertEquals(
            2286,
            bag.sumOfPowerOfAllPossibleGames(
                    """
                                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"""));
  }
}
