import java.util.ArrayList;
import java.util.Collections;

public class CardHolder {
    private ArrayList<Card> Cards;

    //Constructor for n full pack(s)
    public CardHolder(int n) {
        this.Cards = new ArrayList<>();
        //TODO implement different dificulties
        if (n != 0){
            for (int i = 0; i < Card.suitsList.size(); i++) {
                for (int j = 0; j < Card.ranksList.size(); j++) {
                    StringBuilder sb = new StringBuilder();
                    String suit = Card.suitsList.get(i);
                    String rank = Card.ranksList.get(j);
                    sb.append(rank).append(suit);
                    Card uus = new Card(sb.toString());
                    Cards.add(uus);
                }
            }
        }
    }
    //Constructor for empty pack
    public CardHolder() {
        this.Cards = new ArrayList<>();
    }

    //Method to identify whether there are same cards in the deck
    public boolean sameCards(ArrayList<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                String first = list.get(i).toString();
                String second = list.get(j).toString();
                if (first.equals(second)  && i != j)
                    return true;
            }
        }
        return false;
    }
    public ArrayList<Card> getCards() {
        return (ArrayList<Card>) Cards.clone();
    }
    public void shuffle() {
        Collections.shuffle(Cards);
    }
    public Card takeCard() {
        if (!Cards.isEmpty())
            return Cards.remove(0);
        else throw new RuntimeException("CardHolder is empty");
    }
    public void addCard(Card card) {
        Cards.add(card);
    }
}
