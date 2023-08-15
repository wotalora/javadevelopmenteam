import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Shoe {
    private final List<List<BlackjackCard>> cards;
    private final int numberOfDecks;

    public Shoe(int numberOfDecks) {
        cards = new ArrayList<>();
        this.numberOfDecks = numberOfDecks;
        createShoe();
        shuffle();
    }

    public boolean createShoe() {
        for (int decks = 0; decks < numberOfDecks; decks++) {
            Deck deck = new Deck();
            cards.add(deck.getCards());
        }
        if (!(cards.isEmpty())) {
            return true; 
        }
        
        return false; 
    }

    private void shuffle() {
        List<BlackjackCard> allCards = new ArrayList<>();
        for (List<BlackjackCard> deck : cards) {
            allCards.addAll(deck);
        }
        Collections.shuffle(allCards);

        int cardCount = allCards.size();
        for (int i = 0; i < cardCount; i++) {
            int j = (int) (Math.random() * (cardCount - i));
            Collections.swap(allCards, i, i + j);
        }
    }

    public BlackjackCard dealCard() {
        if (cards.isEmpty() || cards.get(0).isEmpty()) {
            createShoe();
        }
        int randomIndex = (int) (Math.random() * (numberOfDecks * 52)); 
        return cards.get(0).get(randomIndex); 
    }
}