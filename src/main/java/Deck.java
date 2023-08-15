import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Deck {
    private final List<BlackjackCard> cards;
    private final Date creationDate; 

    public Deck() {
        cards = new ArrayList<>();
        creationDate = new Date();
        for (int value = 1; value <= 13; value++) {
            for (Suit suit : Suit.values()) {
                cards.add(new BlackjackCard(suit, value));
            }
        }
    }

    public List<BlackjackCard> getCards() {
        return cards;
    }
}