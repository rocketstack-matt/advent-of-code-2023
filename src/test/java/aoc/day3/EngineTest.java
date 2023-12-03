package aoc.day3;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineTest {
  @Test
  void no_symbols_in_first_row() {
    Engine engine = new Engine();
    engine.addSymbolsForRow(0, "467..114..");
    Assertions.assertTrue(engine.symbols.isEmpty());
  }

  @Test
  void one_symbol_in_second_row_at_3_1() {
    Engine engine = new Engine();
    engine.addSymbolsForRow(1, "...*......");
    Assertions.assertEquals(1, engine.symbols.size());
    Assertions.assertTrue(engine.symbols.get(0).symbolIsAs(3, 1));
  }

  @Test
  void no_symbols_in_third_row() {
    Engine engine = new Engine();
    engine.addSymbolsForRow(2, "..35..633.");
    Assertions.assertTrue(engine.symbols.isEmpty());
  }

  @Test
  void one_symbol_in_fourth_row_at_6_3() {
    Engine engine = new Engine();
    engine.addSymbolsForRow(3, "......#...");
    Assertions.assertEquals(1, engine.symbols.size());
    Assertions.assertTrue(engine.symbols.get(0).symbolIsAs(6, 3));
  }

  @Test
  void one_symbol_in_fifth_row_at_3_4() {
    Engine engine = new Engine();
    engine.addSymbolsForRow(4, "617*......");
    Assertions.assertEquals(1, engine.symbols.size());
    Assertions.assertTrue(engine.symbols.get(0).symbolIsAs(3, 4));
  }

  @Test
  void two_symbols_in_ninth_row_at_3_8_and_5_8() {
    Engine engine = new Engine();
    engine.addSymbolsForRow(8, "...$.*....");
    Assertions.assertEquals(2, engine.symbols.size());
    Assertions.assertTrue(engine.symbols.get(0).symbolIsAs(3, 8));
    Assertions.assertTrue(engine.symbols.get(1).symbolIsAs(5, 8));
  }

  @Test
  void two_engine_parts_in_first_row() {
    Engine engine = new Engine();
    engine.addEnginePartsForRow(0, "467..114..");
    Assertions.assertEquals(2, engine.parts.size());
    Assertions.assertEquals(467, engine.parts.get(0).partNumber);
    Assertions.assertEquals(114, engine.parts.get(1).partNumber);
  }

  @Test
  void no_engine_parts_in_second_row() {
    Engine engine = new Engine();
    engine.addEnginePartsForRow(1, "...*......");
    Assertions.assertTrue(engine.parts.isEmpty());
  }

  @Test
  void two_engine_parts_in_third_row() {
    Engine engine = new Engine();
    engine.addEnginePartsForRow(2, "..35..633.");
    Assertions.assertEquals(2, engine.parts.size());
    Assertions.assertEquals(35, engine.parts.get(0).partNumber);
    Assertions.assertEquals(633, engine.parts.get(1).partNumber);
  }

  @Test
  void test_load_schematic() throws FileNotFoundException {
    Engine engine = new Engine("test.input");
    Assertions.assertEquals(6, engine.symbols.size());
    Assertions.assertEquals(10, engine.parts.size());
  }

  @Test
  void test_sum_of_all_valid_engine_parts_equals_4361() throws FileNotFoundException {
    Engine engine = new Engine("test.input");
    Assertions.assertEquals(4361, engine.sumOfAllValidEngineParts());
  }
}
