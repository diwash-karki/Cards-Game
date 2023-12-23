import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();

    Deck() {
        for (CardColorEnum color : CardColorEnum.values()) {
            for (CardNumberEnum number : CardNumberEnum.values()) {
                cards.add(new Card(color, number));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public void showDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
