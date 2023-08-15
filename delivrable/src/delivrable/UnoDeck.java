package delivrable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnoDeck {
    private List<UnoCard> cards;

    public UnoDeck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        for (String color : colors) {
            for (String value : values) {
                cards.add(new UnoCard(color, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UnoCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public int size() {
        return cards.size();
    }

    public static void main(String[] args) {
        UnoDeck deck = new UnoDeck();
        System.out.println("Deck size: " + deck.size());

        UnoCard drawnCard = deck.drawCard();
        if (drawnCard != null) {
            System.out.println("Drawn card: " + drawnCard);
            System.out.println("Deck size after drawing: " + deck.size());
        } else {
            System.out.println("Deck is empty.");
        }
    }
}

