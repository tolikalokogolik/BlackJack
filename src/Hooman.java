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
        int sum = 0;
        int numOfAces = 0;
        for (Card card : cardsOnHand.getCards()){
            if (card.getRank() == "K" && card.getRank() == "Q" && card.getRank() == "J"){
                sum += 10;
            } else if (card.getRank() == "A") {
                numOfAces += 1;
            } else {
                sum += Integer.parseInt(card.getRank());
            }
        }

        if (sum + numOfAces*11 <= 21){
            sum += numOfAces*11;
        } else {
            sum += numOfAces*1;
        }

        return sum;
    }

    public boolean checkLose(){
        if (calculatePoints() > 21) {
            return true;
        }
        return false;
    }
}
