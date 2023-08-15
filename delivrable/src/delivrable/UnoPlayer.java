package delivrable;
import java.util.ArrayList;
import java.util.List;

public class UnoPlayer {
    private String name;
    private List<UnoCard> hand;

    public UnoPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addToHand(UnoCard card) {
        hand.add(card);
    }

    public List<UnoCard> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public boolean hasCardToPlay(String topColor, String topValue) {
        for (UnoCard card : hand) {
            if (card.getColor().equals(topColor) || card.getValue().equals(topValue)) {
                return true;
            }
        }
        return false;
    }

    public UnoCard playCard(int cardIndex) {
        return hand.remove(cardIndex);
    }
}

