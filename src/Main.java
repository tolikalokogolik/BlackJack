public class Main {
    public static void main(String[] args) throws Exception {
        BlackJack.showRules();
        int difficulty = BlackJack.readDifficultyInput();
        BlackJack blackjack = new BlackJack(difficulty);
        blackjack.start();

    }
}