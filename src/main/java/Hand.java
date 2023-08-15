import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<BlackjackCard> cards;

    public Hand(BlackjackCard blackjackCard1) {
        cards = new ArrayList<>();
        cards.add(blackjackCard1);
    }

    public List<Integer> getScores() {
        List<Integer> totals = new ArrayList<>();
        totals.add(0); 

        for (BlackjackCard card : cards) {
            List<Integer> newTotals = new ArrayList<>();
            for (int score : totals) {
                newTotals.add(card.getGameValue()+ score);
                if (card.getFaceValue() == 1) {
                    newTotals.add(11 + score);
                }
            }

            totals = newTotals;
        }

        return totals;
    }

    public Card addCard(BlackjackCard card) {
        cards.add(card);
        return card; 
    }

    public int resolveScore() {
        List<Integer> scores = getScores();
        int bestScore = 0;
        for (int score : scores) {
            if (score <= 21 && score > bestScore) {
                bestScore = score;
            }
        }

        return bestScore;
    }

    List<BlackjackCard> getCards() {
        return cards; 
    }
}
