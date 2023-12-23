
public class Card {
    CardColorEnum color;
    CardNumberEnum number;

    Card(CardColorEnum color, CardNumberEnum number) {
        this.color = color;
        this.number = number;
    }

    public CardColorEnum getColor() {
        return color;
    }

    public CardNumberEnum getNumber() {
        return number;
    }

    public String getRealNumber() {
        if (number == CardNumberEnum.ACE) {
            return "A";
        } else if (number == CardNumberEnum.TWO) {
            return "2";
        } else if (number == CardNumberEnum.THREE) {
            return "3";
        } else if (number == CardNumberEnum.FOUR) {
            return "4";
        } else if (number == CardNumberEnum.FIVE) {
            return "5";
        } else if (number == CardNumberEnum.SIX) {
            return "6";
        } else if (number == CardNumberEnum.SEVEN) {
            return "7";
        } else if (number == CardNumberEnum.EIGHT) {
            return "8";
        } else if (number == CardNumberEnum.NINE) {
            return "9";
        } else if (number == CardNumberEnum.TEN) {
            return "10";
        } else if (number == CardNumberEnum.JACK) {
            return "J";
        } else if (number == CardNumberEnum.QUEEN) {
            return "Q";
        } else if (number == CardNumberEnum.KING) {
            return "K";
        }
        return null;
    }

    public String toString() {
        StringBuilder cardRepresentation = new StringBuilder();
        cardRepresentation.append("┌─────────┐\n");
        cardRepresentation.append("│         │\n");
        cardRepresentation.append("│         │\n");
        cardRepresentation.append("│ ").append(color.name()).append("\n");
        cardRepresentation.append("│   ").append(getRealNumber()).append("\n");
        cardRepresentation.append("│         │\n");
        cardRepresentation.append("│         │\n");
        cardRepresentation.append("└─────────┘\n");
        return cardRepresentation.toString();
    }
}
