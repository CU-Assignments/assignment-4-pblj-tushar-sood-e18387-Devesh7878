import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String toString() {
        return "Symbol: " + symbol + ", Value: " + value;
    }
}

public class CardCollection {
    static Collection<Card> cards = new ArrayList<>();

    static void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }

    static List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.symbol.equals(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Card\n2. Find Cards by Symbol\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter Symbol and Value:");
                addCard(sc.next(), sc.next());
            } else if (choice == 2) {
                System.out.println("Enter Symbol to search:");
                List<Card> result = findCardsBySymbol(sc.next());
                System.out.println(result.isEmpty() ? "No cards found" : result);
            } else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }
}

