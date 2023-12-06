package aoc.day6;

public class RaceRecord {
  int raceLength;
  int record;

  public RaceRecord(int raceLength, int record) {
    this.raceLength = raceLength;
    this.record = record;
  }

  public int getDistanceTravelled(int timeHeld) {
    return timeHeld * (raceLength - timeHeld);
  }

  public int noOfWaysToBeatRecord() {
    int noOfWays = 0;

    for (int i = 0; i <= raceLength; i++) {
      if (getDistanceTravelled(i) > record) {
        noOfWays++;
      }
    }

    return noOfWays;
  }
}
