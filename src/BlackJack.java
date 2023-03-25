//Наверн тут вся игра может быть. Сюда можно while прописать с hit() и pass()
public class BlackJack {
    private CardHolder gamePack;

    public BlackJack() {
        this.gamePack = new CardHolder(1);
    }
    public CardHolder getGamePack() {
        return gamePack;
    }
    public Card takeCard() {
        return gamePack.takeCard();
    }
}
