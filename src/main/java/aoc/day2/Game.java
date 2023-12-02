package aoc.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int id;
    private final List<GameReveal> gameReveals;

    public Game(String gameRecord) {
        String[] parts = gameRecord.split(": ");
        id = Integer.parseInt(parts[0].split(" ")[1]);

        gameReveals = new ArrayList<>();
        String[] reveals = parts[1].split("; ");
        for(String reveal : reveals) {
            gameReveals.add(new GameReveal(reveal));
        }
    }

    public int id() {
        return id;
    }

    public List<GameReveal> reveals() {
        return gameReveals;
    }

    public int powerOfMinCubes() {
        int minRed = 0;
        int minBlue = 0;
        int minGreen = 0;

        for(GameReveal reveal : gameReveals) {
            if(reveal.red() > minRed) minRed = reveal.red();
            if(reveal.blue() > minBlue) minBlue = reveal.blue();
            if(reveal.green() > minGreen) minGreen = reveal.green();
        }

        return minRed * minBlue * minGreen;
    }
}
