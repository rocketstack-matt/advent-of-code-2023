package aoc.day4;

import java.util.ArrayList;
import java.util.List;

public class ScratchCard {
    int cardNo;
    List<Integer> cardNumbers;
    List<Integer> winningNumbers;

    public ScratchCard(int cardNo, List<Integer> winningNumbers, List<Integer> cardNumbers) {
        this.cardNo = cardNo;
        this.winningNumbers = winningNumbers;
        this.cardNumbers = cardNumbers;
    }

    public ScratchCard(String cardString) {
        winningNumbers = new ArrayList<>();
        cardNumbers = new ArrayList<>();

        cardNo = Integer.parseInt(cardString.split(": ")[0].split("\\s+")[1].trim());
        String[] tokens = cardString.split(": ")[1].split(" \\| ");
        for (String winningNumber : tokens[0].trim().split("\\s+")) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        for (String cardNumber : tokens[1].trim().split("\\s+")) {
            cardNumbers.add(Integer.parseInt(cardNumber));
        }
    }

    public boolean isWinner() {
        for (Integer cardNumber : cardNumbers) {
            if (winningNumbers.contains(cardNumber)) {
                return true;
            }
        }
        return false;
    }

    public int cardValue() {
        int winners = 0;
        for (Integer cardNumber : cardNumbers) {
            if (winningNumbers.contains(cardNumber)) {
                winners++;
            }
        }

        int value = 0;
        for (int i = 0; i < winners; i++) {
            if (value == 0) {
                value = 1;
            } else {
                value *= 2;
            }
        }
        return value;
    }

    public int winners() {
        int winners = 0;
        for (Integer cardNumber : cardNumbers) {
            if (winningNumbers.contains(cardNumber)) {
                winners++;
            }
        }
        return winners;
    }
}
