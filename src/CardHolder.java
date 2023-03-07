import java.util.ArrayList;
import java.util.Collections;

public class CardHolder {
    private ArrayList<Card> Cards;

    //ConstructorFullPack
    public CardHolder() {
        this.Cards = new ArrayList<>(); //Safety copy
        for (int i = 0; i < Card.suitsList.size(); i++) {
            for (int j = 0; j < Card.ranksList.size(); j++) {
                StringBuilder sb = new StringBuilder();
                String mast = Card.suitsList.get(i);
                String tugevus = Card.ranksList.get(j);
                sb.append(tugevus).append(mast);
                Card uus = new Card(sb.toString());
                Cards.add(uus);
            }
        }
    }
    //ConstructorPartialPack
    public CardHolder(ArrayList<Card> Cards) {
        this.Cards = new ArrayList<>(); //Safety copy
        if (!kasOnKorduvaid(Cards))
            this.Cards = Cards;
        else throw new RuntimeException("Kaardipakkis on korduvaid Carde");
    }
    //Method to identify whether there are same cards in the deck
    public boolean kasOnKorduvaid(ArrayList<Card> list) {
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
    public void sega() {
        Collections.shuffle(Cards);
    }
    public Card takeCard() {
        if (!Cards.isEmpty())
            return Cards.remove(0);
        else throw new RuntimeException("Kaardipakk on tühi");
    }
}
