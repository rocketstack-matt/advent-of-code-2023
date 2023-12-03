package aoc.day3;

import java.util.ArrayList;
import java.util.List;

public class EngineSymbol {
  int x, y;
  List<EnginePart> adjacentEngineParts = new ArrayList<>();

  public EngineSymbol(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean symbolIsAs(int x, int y) {
    return this.x == x && this.y == y;
  }

  public boolean partIsValid(EnginePart part) {
    boolean directlyLeft = x == part.x1 - 1 && y == part.y;
    boolean directlyRight = x == part.x2 + 1 && y == part.y;
    boolean directlyAbove = x >= part.x1 && x <= part.x2 && y == part.y - 1;
    boolean directlyBelow = x >= part.x1 && x <= part.x2 && y == part.y + 1;
    boolean diaganolLeftAndUp = x == part.x1 - 1 && y == part.y - 1;
    boolean diaganolRightAndUp = x == part.x2 + 1 && y == part.y - 1;
    boolean diaganolLeftAndDown = x == part.x1 - 1 && y == part.y + 1;
    boolean diaganolRightAndDown = x == part.x2 + 1 && y == part.y + 1;
    return directlyLeft
        || directlyRight
        || directlyAbove
        || directlyBelow
        || diaganolLeftAndUp
        || diaganolRightAndUp
        || diaganolLeftAndDown
        || diaganolRightAndDown;
  }

  public boolean isGear(List<EnginePart> parts) {
    adjacentEngineParts = new ArrayList<>();
    for (EnginePart part : parts) {
      if (partIsValid(part)) {
        adjacentEngineParts.add(part);
      }
    }
    return adjacentEngineParts.size() == 2;
  }

  public int gearRatio() throws Exception {
    if (adjacentEngineParts.size() != 2) {
      throw new Exception("Not a gear");
    }
    return adjacentEngineParts.get(0).partNumber * adjacentEngineParts.get(1).partNumber;
  }
}
