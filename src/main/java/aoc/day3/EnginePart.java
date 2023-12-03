package aoc.day3;

public class EnginePart {
  int x1, x2, y;
  int partNumber;

  public EnginePart(int x1, int x2, int y, String partNumber) {
    this.x1 = x1;
    this.x2 = x2;
    this.y = y;
    this.partNumber = Integer.parseInt(partNumber);
  }
}
