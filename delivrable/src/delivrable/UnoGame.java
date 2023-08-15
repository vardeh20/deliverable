package delivrable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnoGame {
    private List<UnoPlayer> players;
    private UnoDeck deck;
    private List<UnoCard> discardPile;
    private int currentPlayerIndex;
    private String currentColor;

    public UnoGame(List<UnoPlayer> players) {
        this.players = players;
        this.deck = new UnoDeck();
        this.discardPile = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void startGame() {
        for (int i = 0; i < 7; i++) {
            for (UnoPlayer player : players) {
                player.addToHand(deck.drawCard());
            }
        }

        UnoCard topCard = deck.drawCard();
        if (topCard != null) {
            discardPile.add(topCard);
            currentColor = topCard.getColor();
        }
    }

    public void playTurn(UnoPlayer player) {
        System.out.println(player.getName() + "'s turn.");
        System.out.println("Top Card: " + discardPile.get(discardPile.size() - 1));

        if (player.hasCardToPlay(currentColor, discardPile.get(discardPile.size() - 1).getValue())) {
            int cardIndex = getPlayerInput(player);
            UnoCard playedCard = player.playCard(cardIndex);
            discardPile.add(playedCard);
            currentColor = playedCard.getColor();
            System.out.println(player.getName() + " played: " + playedCard);
        } else {
            System.out.println(player.getName() + " has no valid cards to play. Drawing a card.");
            player.addToHand(deck.drawCard());
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private int getPlayerInput(UnoPlayer player) {
        Scanner scanner = new Scanner(System.in);
        List<UnoCard> hand = player.getHand();

        System.out.println("Your Hand: ");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i));
        }

        int choice;
        do {
            System.out.print("Enter the index of the card you want to play: ");
            choice = scanner.nextInt();
        } while (choice < 0 || choice >= hand.size());

        return choice;
    }

    private boolean checkForWinner(UnoPlayer player) {
        return player.getHand().isEmpty();
    }

    public void playGame() {
        startGame();
        while (!isGameOver()) {
            UnoPlayer currentPlayer = players.get(currentPlayerIndex);
            playTurn(currentPlayer);
            if (checkForWinner(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins!");
                return;
            }
        }

        System.out.println("Game Over!");
    }

    private boolean isGameOver() {
        for (UnoPlayer player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UnoPlayer player1 = new UnoPlayer("Player 1");
        UnoPlayer player2 = new UnoPlayer("Player 2");
        List<UnoPlayer> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        UnoGame game = new UnoGame(players);
        game.playGame();
    }

}

