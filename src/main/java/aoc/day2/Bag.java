package aoc.day2;

public class Bag {
  private final int red;
  private final int blue;
  private final int green;

  public Bag() {
    this(0, 0, 0);
  }

  // Colours represent how many of that colour cube are in the bag.
  public Bag(int red, int blue, int green) {
    this.red = red;
    this.blue = blue;
    this.green = green;
  }

  public boolean validGame(String gameRecord) {
    Game game = new Game(gameRecord);
    for (GameReveal reveal : game.reveals()) {
      if (reveal.red() > red) return false;
      if (reveal.blue() > blue) return false;
      if (reveal.green() > green) return false;
    }
    return true;
  }

  public int sumOfValidGames(String gameRecords) {
    int sum = 0;
    String[] games = gameRecords.split("\n");
    for (String game : games) {
      if (validGame(game)) {
        sum += new Game(game).id();
      }
    }
    return sum;
  }

  public int sumOfPowerOfAllPossibleGames(String gameRecords) {
    int sum = 0;
    String[] games = gameRecords.split("\n");
    for (String game : games) {
      sum += new Game(game).powerOfMinCubes();
    }
    return sum;
  }
}
