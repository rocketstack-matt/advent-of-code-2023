package aoc.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;
    private List<GameReveal> gameReveals;

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
}
