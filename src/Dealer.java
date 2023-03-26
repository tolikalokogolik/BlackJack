public class Dealer extends Hooman{
    private Card firstCard;
    private CardHolder cardsOnHand;

    public Dealer() {
        this.cardsOnHand = new CardHolder();
    }

    @Override
    public void hit(Card card) {
        // when taking first crad we need to remember it to show it to the player.
        if (cardsOnHand.size() == 0){
            this.firstCard = card;
        }
        super.hit(card);
    }

    public void dealerTakesCard(){
        System.out.println("Diiler otsustas võtta kaardi");
    }

    public void showFirstCard(){
        System.out.println("Dealers first card is: " + firstCard.getSuit() + firstCard.getRank());
    }
}
