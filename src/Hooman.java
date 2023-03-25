public class Hooman {
    private CardHolder cardsOnHand;

    public Hooman() {
        this.cardsOnHand = new CardHolder();
    }

    //TODO implement ending turn
    public void endturn(){
    }
    public void hit(Card card) {
        cardsOnHand.addCard(card);
    }
    public void pass() {
        this.endturn();
    }
    public int checkValue() {
        return cardsOnHand.cardsToValue();
    }

    public int calculatePoints(){
        //TODO: add calculation of points
        return 0;
    }

    public boolean checkLose(){
        if (calculatePoints() > 21) {
            return true;
        }
        return false;
    }
}
