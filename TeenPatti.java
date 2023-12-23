import java.util.Scanner;
import java.util.ArrayList;

public class TeenPatti {
    public static void main(String[] args) {
        // welcomeScreen();
        // int choice = selectMenu(new Scanner(System.in));
        // switch (choice) {
        // case 1:
        // play();
        // break;
        // case 2:
        // System.out.println("Goodbye!");
        // break;
        // default:
        // System.out.println("Invalid choice");
        // break;
        // }
        int c = 20;
        while (c-- > 0){
            play();
        }
        
    }

    public static void welcomeScreen() {
        System.out.println("----------------------");
        System.out.println("Welcome to Teen Patti!");
        System.out.println("----------------------");
        System.out.println("1. Play");
        System.out.println("2. Exit");
    }

    public static Integer selectMenu(Scanner scn) {
        Integer choice = scn.nextInt();
        return choice;
    }

    public static Player checkWinnerPlayer(ArrayList<Player> players) {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.compareTo(winner) > 0) {
                winner = player;
            }
        }
        return winner;
    }

    public static void play() {
        // System.out.println("How many players?");
        // Scanner scn = new Scanner(System.in);
        // int numPlayers = scn.nextInt();

        ArrayList<Player> players = new ArrayList<>();
        // for (int i = 0; i < numPlayers; i++) {
        // System.out.println("Enter player " + (i + 1) + "'s name:");
        // String name = scn.next();
        // players.add(new Player(name));
        // }

        players.add(new Player("Karsang"));
        players.add(new Player("Sarthak"));

        Deck deck = new Deck();
        for (Player player : players) {
            for (int i = 0; i < 3; i++) {
                player.addCard(deck.draw());
            }
        }
        for (Player player : players) {
            System.out.println();
            player.showHand();
        }
        Player winner = checkWinnerPlayer(players);

        System.out.println("\n\nThe winner is " + winner.getName() + " by " + winner.getWinType() + "!");
        System.out.println("The winning hand is: \n" + winner.getHand());

        System.out.println( "\n-----------------------------------------------------------------------------------\n");
    }
}
