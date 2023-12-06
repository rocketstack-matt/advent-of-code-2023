package aoc.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordTrackerTest {
  @Test
  void total_number_of_ways_to_beat_9mm_record_in_7ms_race_is_4() {
    RecordTracker tracker = new RecordTracker();
    tracker.addRecord(7, 9);
    Assertions.assertEquals(4, tracker.totalNoOfWaysToBeatRecords());
  }

  @Test
  void
      total_number_of_ways_to_beat_9mm_record_in_7ms_and_40ms_record_in_15ms_and_200mm_race_in_30ms_is_288() {
    RecordTracker tracker = new RecordTracker();
    tracker.addRecord(7, 9);
    tracker.addRecord(15, 40);
    tracker.addRecord(30, 200);
    Assertions.assertEquals(288, tracker.totalNoOfWaysToBeatRecords());
  }
}
