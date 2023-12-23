import java.util.ArrayList;

public class UnitTest {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Card c1 = new Card(CardColorEnum.CLUB, CardNumberEnum.FOUR);
        Card c2 = new Card(CardColorEnum.CLUB, CardNumberEnum.SEVEN);
        Card c3 = new Card(CardColorEnum.CLUB, CardNumberEnum.SEVEN);

        Player p1 = new Player("Player 1");
        p1.addCard(c1);
        p1.addCard(c2);
        p1.addCard(c3);

        Card c4 = new Card(CardColorEnum.CLUB, CardNumberEnum.NINE);
        Card c5 = new Card(CardColorEnum.CLUB, CardNumberEnum.TWO);
        Card c6 = new Card(CardColorEnum.CLUB, CardNumberEnum.TWO);

        Player p2 = new Player("Player 2");
        p2.addCard(c4);
        p2.addCard(c5);
        p2.addCard(c6);

        players.add(p1);
        players.add(p2);

        Player winner = checkWinnerPlayer(players);
        p1.showHand();
        p2.showHand();
        
            System.out.println(winner.getName() + " wins!" + " with " + winner.getWinType());
        

    }

    public static Player checkWinnerPlayer(ArrayList<Player> players) {
        Player winner = players.remove(0);
        for (Player player : players) {
            if (player.compareTo(winner) > 0) {
                winner = player;
            }
        }
        return winner;
    }
}
