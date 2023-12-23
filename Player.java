import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Player {
    String name;
    ArrayList<Card> hand = new ArrayList<>();
    WinType winType;

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
            System.out.println(card);
        }
        System.out.println();
    }

    void setWinType(WinType winType) {
        this.winType = winType;
    }

    WinType getWinType() {
        return winType;
    }

    int isTrial(Player opponent) {
        HashSet<Integer> p1 = new HashSet<>();
        for (Card card : hand) {
            p1.add(card.getNumber().ordinal());
        }
        HashSet<Integer> p2 = new HashSet<>();
        for (Card card : opponent.hand) {
            p2.add(card.getNumber().ordinal());
        }
        if (p1.size() == 1 && p2.size() == 1) {
            if (this.hand.get(0).getNumber().ordinal() > opponent.hand.get(0).getNumber().ordinal()) {
                return 1;
            } else if (this.hand.get(0).getNumber().ordinal() < opponent.hand.get(0).getNumber().ordinal()) {
                return -1;
            } else {
                return 0;
            }
        } else if (p1.size() == 1) {
            return 1;
        } else if (p2.size() == 1) {
            return -1;
        } else {
            return 2;
        }
    }

    int doubleSequence(Player opponent){
        int seq = this.sequence(opponent);
        int col = this.colors(opponent);
        if(seq == 1 && col == 1){
            return 1;
        }else if(seq == -1 && col == -1){
            return -1;
        }else{
            return 2;
        }
    }

    

    int sequence(Player opponent) {
        int p1Max = 0;
        int p2Max = 0;
        boolean p1IsSeq = false;
        boolean p2IsSeq = false;

        Integer[] p1 = new Integer[hand.size()];
        for (int i = 0; i < hand.size(); i++) {
            p1[i] = hand.get(i).getNumber().ordinal();
        }
        Integer[] p2 = new Integer[opponent.hand.size()];
        for (int i = 0; i < opponent.hand.size(); i++) {
            p2[i] = opponent.hand.get(i).getNumber().ordinal();
        }
        Collections.sort(hand, new SortByNumber());
        Collections.sort(opponent.hand, new SortByNumber());
        for (int i = 1; i < p1.length; i++) {
            // Check if the current element is not one more than the previous element
            if (p1[i] != p1[i - 1] + 1) {
                p1IsSeq = false;
                p1Max = Math.max(p1Max, i);
            }
        }
        for (int i = 1; i < p2.length; i++) {
            // Check if the current element is not one more than the previous element
            if (p2[i] != p2[i - 1] + 1) {
                p2IsSeq = false;
                p2Max = Math.max(p2Max, i);
            }
        }

        if (p1IsSeq && p2IsSeq) {
            if (p1Max > p2Max) {
                return 1;
            } else if (p1Max < p2Max) {
                return -1;
            } else {
                return 0;
            }
        } else if (p1IsSeq) {
            return 1;
        } else if (p2IsSeq) {
            return -1;
        } else {
            return 2;
        }

    }

    int colors(Player opponent) {
        HashSet<CardColorEnum> p1 = new HashSet<>();
        for (Card card : hand) {
            p1.add(card.getColor());
        }
        HashSet<CardColorEnum> p2 = new HashSet<>();
        for (Card card : opponent.hand) {
            p2.add(card.getColor());
        }

        if (p1.size() == 1 && p2.size() == 1) {
            if (this.hand.get(0).getNumber().ordinal() > opponent.hand.get(0).getNumber().ordinal()) {
                return 1;
            } else if (this.hand.get(0).getNumber().ordinal() < opponent.hand.get(0).getNumber().ordinal()) {
                return -1;
            } else {
                return 0;
            }
        } else if (p1.size() == 1) {
            return 1;
        } else if (p2.size() == 1) {
            return -1;
        } else {
            return 2;
        }

    }

    int cardPair(Player opponent) {
        HashSet<Integer> p1 = new HashSet<>();
        for (Card card : hand) {
            p1.add(card.getNumber().ordinal());
        }
        HashSet<Integer> p2 = new HashSet<>();
        for (Card card : opponent.hand) {
            p2.add(card.getNumber().ordinal());
        }

        if (p1.size() == 2 && p2.size() == 2) {
            if (this.hand.get(0).getNumber().ordinal() > opponent.hand.get(0).getNumber().ordinal()) {
                return 1;
            } else if (this.hand.get(0).getNumber().ordinal() < opponent.hand.get(0).getNumber().ordinal()) {
                return -1;
            } else {
                return 0;
            }
        } else if (p1.size() == 2) {
            return 1;
        } else if (p2.size() == 2) {
            return -1;
        } else {
            return 2;
        }
    }

    int highestCard(Player opponent) {
        if (this.hand.get(0).getNumber().ordinal() > opponent.hand.get(0).getNumber().ordinal()) {
            return 1;
        } else if (this.hand.get(0).getNumber().ordinal() < opponent.hand.get(0).getNumber().ordinal()) {
            return -1;
        } else {
            return 0;
        }
    }

    public int compareTo(Player other) {
        this.hand.sort(new SortByNumber());
        other.hand.sort(new SortByNumber());

        // // trial
        // Integer trial = this.isTrial(other);
        // if (trial != 2) {
        //     this.setWinType(WinType.TRIAL);
        //     return trial;
        // }

        // // double sequence
        // Integer doubleSeq = this.doubleSequence(other);
        // if (doubleSeq != 2) {
        //     this.setWinType(WinType.DOUBLE_SEQUENCE);
        //     return doubleSeq;
        // }

        // // sequence
        // Integer seq = this.sequence(other);
        // if (seq != 2) {
        //     this.setWinType(WinType.SEQUENCE);
        //     return seq;
        // }

        // // color
        // Integer color = this.colors(other);
        // if (color != 2) {
        //     this.setWinType(WinType.COLOR);
        //     return color;
        // }

        // // pair
        // Integer pair = this.cardPair(other);
        // if (pair != 2) {
        //     this.setWinType(WinType.PAIR);
        //     return pair;
        // }

        // highest card
        Integer highest = this.highestCard(other);
        if (highest != 0) {
            this.setWinType(WinType.HIGH_CARD);
            return highest;
        }

        this.setWinType(WinType.DRAW);

        return 0;

    }
}
