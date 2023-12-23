import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player {
    String name;
    ArrayList<Card> hand = new ArrayList<>();

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addCard(Card card) {
        hand.add(card);
    }

    ArrayList<Card> getHand() {
        return hand;
    }

    void showHand() {
        System.out.println("Player " + name + " has the following cards:");
        for (Card card : hand) {
            System.out.print(card);
        }
        System.out.println();
    }


    public int compareTo(Player other) {
        Player winner;
        this.hand.sort(new SortByNumber());
        other.hand.sort(new SortByNumber());

        int countTemp = 0;

        //trial
        Integer p1CardTemp = 0;
        Integer p2CardTemp = 0;
       


        while (countTemp < this.hand.size()) {
            if (this.hand.get(countTemp).getNumber().ordinal() > other.hand.get(countTemp).getNumber().ordinal()) {
                winner = this;
                return 1;
            } else if (this.hand.get(countTemp).getNumber().ordinal() < other.hand.get(countTemp).getNumber()
                    .ordinal()) {
                winner = other;
                return -1;
            } else {
                countTemp++;
            }
        }
        return 0;

    }
}
