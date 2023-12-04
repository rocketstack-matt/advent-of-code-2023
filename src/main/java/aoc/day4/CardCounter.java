package aoc.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardCounter {
    Map<Integer, ScratchCard> scratchCards = new HashMap<>();

    public CardCounter(String filename) throws FileNotFoundException {
        String filepath = Objects.requireNonNull(getClass().getResource(filename)).getFile();
        Scanner scanner = new Scanner(new File(filepath));

        while (scanner.hasNextLine()) {
            ScratchCard scratchCard = new ScratchCard(scanner.nextLine());
            scratchCards.put(scratchCard.cardNo, scratchCard);
        }
    }

    public Map<Integer, Integer> scratchCardCounts() {
        Map<Integer, Integer> scratchCardCounts = new HashMap<>();
        for (ScratchCard scratchCard : scratchCards.values()) {
            scratchCardCounts.put(scratchCard.cardNo, scratchCardCounts.getOrDefault(scratchCard.cardNo, 0) + 1);
            for (int copiesOfCard = 0; copiesOfCard < scratchCardCounts.get(scratchCard.cardNo); copiesOfCard++) {
                for (int i = scratchCard.cardNo + 1; i < (scratchCard.cardNo + 1) + scratchCard.winners(); i++) {
                    scratchCardCounts.put(i, scratchCardCounts.getOrDefault(i, 0) + 1);
                }
            }
        }
        return scratchCardCounts;
    }

    public long totalCardCount() {
        return scratchCardCounts().values().stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum();
    }
}
