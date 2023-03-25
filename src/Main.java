public class Main {
    public static void main(String[] args) {
        BlackJack.showRules();
        // int difficulty = BlackJack.readDifficultyInput();
        BlackJack blackjack = new BlackJack();
        blackjack.start();
    }
}