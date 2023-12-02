package aoc.day2;

public class GameReveal {

  private int red;
  private int blue;
  private int green;

  public GameReveal(String gameRecordSegment) {
    String[] elements = gameRecordSegment.split(", ");
    for (String element : elements) {
      String[] parts = element.split(" ");
      String colour = parts[1].trim();
      int count = Integer.parseInt(parts[0]);
      switch (colour) {
        case "red":
          red = count;
          break;
        case "blue":
          blue = count;
          break;
        case "green":
          green = count;
          break;
      }
    }
  }

  public int red() {
    return red;
  }

  public int blue() {
    return blue;
  }

  public int green() {
    return green;
  }
}
