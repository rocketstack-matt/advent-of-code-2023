package aoc.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EngineSymbolTest {
  @Test
  void symbol_is_at_1_2() {
    EngineSymbol symbol = new EngineSymbol(1, 2);
    Assertions.assertTrue(symbol.symbolIsAs(1, 2));
  }

  @Test
  void symbol_is_not_at_0_0() {
    EngineSymbol symbol = new EngineSymbol(1, 2);
    Assertions.assertFalse(symbol.symbolIsAs(0, 0));
  }

  @Test
  void part_directly_to_left_is_valid() {
    EngineSymbol symbol = new EngineSymbol(0, 3);
    EnginePart part = new EnginePart(0, 2, 4, "617");
    Assertions.assertTrue(symbol.partIsValid(part));
  }

  @Test
  void part_one_away_to_right_is_invalid() {
    EngineSymbol symbol = new EngineSymbol(5, 5);
    EnginePart part = new EnginePart(7, 8, 5, "58");
    Assertions.assertFalse(symbol.partIsValid(part));
  }

  @Test
  void part_diaganol_to_left_and_up_is_valid() {
    EngineSymbol symbol = new EngineSymbol(3, 1);
    EnginePart part = new EnginePart(0, 2, 0, "467");
    Assertions.assertTrue(symbol.partIsValid(part));
  }

  @Test
  void part_directly_beneath_is_valid() {
    EngineSymbol symbol = new EngineSymbol(4, 1);
    EnginePart part = new EnginePart(2, 3, 2, "35");
    Assertions.assertTrue(symbol.partIsValid(part));
  }

  @Test
  void part_directly_above_is_valid() {
    EngineSymbol symbol = new EngineSymbol(3, 8);
    EnginePart part = new EnginePart(1, 3, 9, "664");
    Assertions.assertTrue(symbol.partIsValid(part));
  }

  @Test
  void part_diaganol_up_and_right_is_valid() {
    EngineSymbol symbol = new EngineSymbol(5, 8);
    EnginePart part = new EnginePart(6, 8, 7, "755");
    Assertions.assertTrue(symbol.partIsValid(part));
  }

  @Test
  void engine_symbol_is_gear() {
    EngineSymbol symbol = new EngineSymbol(3, 1);
    EnginePart part1 = new EnginePart(0, 2, 0, "467");
    EnginePart part2 = new EnginePart(5, 7, 0, "114");
    EnginePart part3 = new EnginePart(2, 3, 2, "35");
    Assertions.assertTrue(symbol.isGear(List.of(part1, part2, part3)));
  }

  @Test
  void engine_symbol_is_not_gear() {
    EngineSymbol symbol = new EngineSymbol(3, 1);
    EnginePart part1 = new EnginePart(0, 2, 0, "467");
    EnginePart part2 = new EnginePart(5, 7, 0, "114");
    Assertions.assertFalse(symbol.isGear(List.of(part1, part2)));
  }

  @Test
  void engine_symbol_is_not_gear_too_many_parts() {
    EngineSymbol symbol = new EngineSymbol(3, 1);
    EnginePart part1 = new EnginePart(0, 2, 0, "467");
    EnginePart part2 = new EnginePart(4, 6, 0, "114");
    EnginePart part3 = new EnginePart(2, 3, 2, "35");
    Assertions.assertFalse(symbol.isGear(List.of(part1, part2, part3)));
  }

  @Test
  void gear_ratio_is_16345() throws Exception {
    EngineSymbol symbol = new EngineSymbol(3, 1);
    EnginePart part1 = new EnginePart(0, 2, 0, "467");
    EnginePart part2 = new EnginePart(5, 7, 0, "114");
    EnginePart part3 = new EnginePart(2, 3, 2, "35");
    symbol.isGear(List.of(part1, part2, part3));
    Assertions.assertEquals(16345, symbol.gearRatio());
  }

  @Test
  void gear_ratio_is_451490() throws Exception {
    EngineSymbol symbol = new EngineSymbol(5, 8);
    EnginePart part1 = new EnginePart(6, 8, 7, "755");
    EnginePart part2 = new EnginePart(5, 7, 9, "598");
    symbol.isGear(List.of(part1, part2));
    Assertions.assertEquals(451490, symbol.gearRatio());
  }
}
