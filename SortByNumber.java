import java.util.Comparator;

public class SortByNumber implements Comparator<Card> {
    public int compare(Card a, Card b) {
        return b.getNumber().ordinal() - a.getNumber().ordinal();
    }
}
