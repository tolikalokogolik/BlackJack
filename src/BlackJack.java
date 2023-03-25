import java.util.Scanner;

//Наверн тут вся игра может быть. Сюда можно while прописать с hit() и pass()
public class BlackJack {
    private final CardHolder gamePack;
    private final Gamer gamer;
    private final Dealer dealer;

    public void start(){
        while (true){

        }

    }

    // Constructors for initting game, base difficulty = 1
    // TODO: implement difficulties (more than one cardpack)
    public BlackJack(int difficulty) {
        this.gamePack = new CardHolder(difficulty);
        this.gamer = new Gamer();
        this.dealer = new Dealer();
    }
    public BlackJack() {
        this.gamer = new Gamer();
        this.dealer = new Dealer();
        this.gamePack = new CardHolder(1);
    }
    public CardHolder getGamePack() {
        return gamePack;
    }
    public Card takeCard() {
        return gamePack.takeCard();
    }

    // Function rules() prints out the rules
    public void showRules(){
        // TODO add rules
        System.out.println("There will be rules");
    }

    private void showLoseMessage(int playerPoints) {
        if (playerPoints > 21) {
            System.out.println("Sul on liiga palju punkte!");
        } else {
            System.out.println("Diiler sai rohkem punkte!");
        }
    }

    public static String readDifficultyInput() {
        String input;
        while (true){
            System.out.println("Sisesta raskustase (1-3): ");
            Scanner scan = new Scanner(System.in);
            input = scan.next();
            if (!input.equals("1") && !input.equals("2") && !input.equals("3")){
                System.out.println("Sisestatud raskustase on vigane.");
                continue;
            } else {
                break;
            }
        }
        return input;
    }

    private void showWinMessage() {
        System.out.println("Võitsid mängu, tubli!");
        // TODO add stats: wins and loses stats
    }


}
