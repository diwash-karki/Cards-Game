// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Random;
// import java.util.HashMap;
// import java.util.Scanner;
// // hashmap

// public class Main {
//     public static void main(String[] args) {

//         ArrayList<HashMap<Colors, Number>> deck = new ArrayList<>();
//         ArrayList<Colors> colors = new ArrayList<>();
//         Colors spade = Colors.SPADE;
//         Colors heart = Colors.HEART;
//         Colors diamond = Colors.DIAMOND;
//         Colors club = Colors.CLUB;
//         Collections.addAll(colors, spade, heart, diamond, club);

//         // Initialize the deck

//         for (Colors color : colors) {
//             for (Number num : Number.values()) {
//                 HashMap<Colors, Number> card = new HashMap<>();
//                 card.put(color, num);
//                 deck.add(card);
//             }
//         }

//         // Shuffle the deck

//         Collections.shuffle(deck);
//         mainMenu(deck);

//     }

//     public static void mainMenu(ArrayList<HashMap<Colors, Number>> deck) {
//         System.out.println("Welcome to the card game!");
//         System.out.println("1. Play");
//         System.out.println("2. Exit");
//         Scanner scn = new Scanner(System.in);
//         int choice = scn.nextInt();
//         switch (choice) {
//             case 1:
//                 play(deck);
//                 break;
//             case 2:
//                 System.out.println("Goodbye!");
//                 break;
//             default:
//                 System.out.println("Invalid choice");
//                 mainMenu(deck);
//                 break;
//         }
//     }

//     public static void play(ArrayList<HashMap<Colors, Number>> deck) {
//         System.out.println("How many players?");
//         Scanner scn = new Scanner(System.in);
//         int numPlayers = scn.nextInt();
//         ArrayList<Player> players = new ArrayList<>();
//         for (int i = 0; i < numPlayers; i++) {
//             System.out.println("Enter player name:");
//             String name = scn.next();
//             Player player = new Player(name);
//             players.add(player);
//         }

//         System.out.println("Dealing cards...");

//         for (int i = 0; i < 3; i++) {
//             for (Player player : players) {
//                 player.addCard(deck.get(0));
//                 deck.remove(0);
//             }
//         }
//         for (Player player : players) {
//             player.showHand();
//         }
//     }

// }