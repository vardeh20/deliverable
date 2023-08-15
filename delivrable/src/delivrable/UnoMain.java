package delivrable;


import java.util.ArrayList;
import java.util.List;

public class UnoMain {
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

