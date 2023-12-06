package aoc.day6;

import java.util.ArrayList;
import java.util.List;

public class RecordTracker {
  List<RaceRecord> records = new ArrayList<>();

  public void addRecord(int raceLength, int record) {
    records.add(new RaceRecord(raceLength, record));
  }

  public long totalNoOfWaysToBeatRecords() {
    long totalNoOfWays = 0;

    for (RaceRecord record : records) {
      if (totalNoOfWays == 0) totalNoOfWays = record.noOfWaysToBeatRecord();
      else totalNoOfWays *= record.noOfWaysToBeatRecord();
    }

    return totalNoOfWays;
  }

  public static void main(String[] args) {
    RecordTracker tracker = new RecordTracker();
    tracker.addRecord(53, 275);
    tracker.addRecord(71, 1181);
    tracker.addRecord(78, 1215);
    tracker.addRecord(80, 1524);
    System.out.println(tracker.totalNoOfWaysToBeatRecords());
  }
}
