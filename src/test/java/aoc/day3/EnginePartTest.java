package aoc.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnginePartTest {
  @Test
  void engine_part_is_created_with_x1_1_x2_2_y_3_and_part_number_4() {
    EnginePart enginePart = new EnginePart(1, 2, 3, "4");
    Assertions.assertEquals(1, enginePart.x1);
    Assertions.assertEquals(2, enginePart.x2);
    Assertions.assertEquals(3, enginePart.y);
    Assertions.assertEquals(4, enginePart.partNumber);
  }
}
