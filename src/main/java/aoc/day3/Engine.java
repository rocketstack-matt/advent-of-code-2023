package aoc.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Engine {
  List<EngineSymbol> symbols = new ArrayList<>();
  List<EnginePart> parts = new ArrayList<>();

  // Just for testing.
  Engine() {}

  public Engine(String engineSchematic) throws FileNotFoundException {
    String filepath = Objects.requireNonNull(getClass().getResource(engineSchematic)).getFile();
    Scanner scanner = new Scanner(new File(filepath));
    int y = 0;
    while (scanner.hasNextLine()) {
      addSymbolsForRow(y, scanner.nextLine());
      y++;
    }
    scanner.close();

    scanner = new Scanner(new File(filepath));
    y = 0;
    while (scanner.hasNextLine()) {
      addEnginePartsForRow(y, scanner.nextLine());
      y++;
    }
  }

  void addSymbolsForRow(int row, String line) {
    for (int x = 0; x < line.length(); x++) {
      if (line.charAt(x) != '.' && !Character.isDigit(line.charAt(x))) {
        symbols.add(new EngineSymbol(x, row));
      }
    }
  }

  void addEnginePartsForRow(int row, String line) {
    for (int x1 = 0; x1 < line.length(); x1++) {
      if (Character.isDigit(line.charAt(x1))) {
        for (int x2 = x1; x2 < line.length(); x2++) {
          if (x2 == line.length() - 1 || !Character.isDigit(line.charAt(x2 + 1))) {
            parts.add(new EnginePart(x1, x2, row, line.substring(x1, x2 + 1)));
            x1 = x2;
            break;
          }
        }
      }
    }
  }

  int sumOfAllValidEngineParts() {
    int sum = 0;
    for (EnginePart part : parts) {
      for (EngineSymbol symbol : symbols) {
        if (symbol.partIsValid(part)) {
          sum += part.partNumber;
          break;
        }
      }
    }
    return sum;
  }
}
