public class Hooman {
    private CardHolder cardsOnHand;
    private BlackJack blackJack;

    public Hooman(BlackJack blackJack) {
        this.cardsOnHand = new CardHolder();
        this.blackJack = blackJack;
    }

    //TODO implement ending turn
    public void endturn(){

    }

    public void hit() {
        Card card = blackJack.takeCard();
        cardsOnHand.addCard(card);
    }
    public void pass() {
        this.endturn();
    }
}
