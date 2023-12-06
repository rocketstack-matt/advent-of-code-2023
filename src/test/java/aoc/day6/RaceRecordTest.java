package aoc.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceRecordTest {

  RaceRecord record;

  @BeforeEach
  void setup() {
    record = new RaceRecord(7, 9);
  }

  @Test
  void boat_held_for_0_ms_can_travel_for_0_mm() {
    Assertions.assertEquals(0, record.getDistanceTravelled(0));
  }

  @Test
  void boat_held_for_1_ms_can_travel_for_6_mm() {
    Assertions.assertEquals(6, record.getDistanceTravelled(1));
  }

  @Test
  void boat_held_for_2_ms_can_travel_for_10_mm() {
    Assertions.assertEquals(10, record.getDistanceTravelled(2));
  }

  @Test
  void boat_held_for_3_ms_can_travel_for_12_mm() {
    Assertions.assertEquals(12, record.getDistanceTravelled(3));
  }

  @Test
  void boat_held_for_4_ms_can_travel_for_12_mm() {
    Assertions.assertEquals(12, record.getDistanceTravelled(4));
  }

  @Test
  void boat_held_for_5_ms_can_travel_for_10_mm() {
    Assertions.assertEquals(10, record.getDistanceTravelled(5));
  }

  @Test
  void boat_held_for_6_ms_can_travel_for_6_mm() {
    Assertions.assertEquals(6, record.getDistanceTravelled(6));
  }

  @Test
  void boat_held_for_7_ms_can_travel_for_0_mm() {
    Assertions.assertEquals(0, record.getDistanceTravelled(7));
  }

  @Test
  void number_of_ways_to_travel_more_than_9mm_in_7ms_race_is_4() {
    RaceRecord record = new RaceRecord(7, 9);
    Assertions.assertEquals(4, record.noOfWaysToBeatRecord());
  }

  @Test
  void number_of_ways_to_travel_more_than_40mm_in_15ms_race_is_8() {
    RaceRecord record = new RaceRecord(15, 40);
    Assertions.assertEquals(8, record.noOfWaysToBeatRecord());
  }

  @Test
  void number_of_ways_to_travel_more_thank_200mm_in_30ms_race_is_9() {
    RaceRecord record = new RaceRecord(30, 200);
    Assertions.assertEquals(9, record.noOfWaysToBeatRecord());
  }
}
