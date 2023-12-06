package aoc.day6;

public class RaceRecord {
  long raceLength;
  long record;

  public RaceRecord(long raceLength, long record) {
    this.raceLength = raceLength;
    this.record = record;
  }

  public long getDistanceTravelled(long timeHeld) {
    return timeHeld * (raceLength - timeHeld);
  }

  public long noOfWaysToBeatRecord() {
    int noOfWays = 0;

    for (long i = 0; i <= raceLength; i++) {
      if (getDistanceTravelled(i) > record) {
        noOfWays++;
      }
    }

    return noOfWays;
  }

  public static void main(String[] args) {
    RaceRecord record = new RaceRecord(53717880L, 275118112151524L);
    System.out.println(record.noOfWaysToBeatRecord());
  }
}
