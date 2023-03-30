import java.util.Scanner;

//Наверн тут вся игра может быть. Сюда можно while прописать с hit() и pass()
public class BlackJack {
    private final CardHolder gamePack;
    private final Player player;
    private final Dealer dealer;

    public void start(){
        String gamerChoice;
        // Giving first cards
        player.hit(gamePack.takeCard());
        dealer.hit(gamePack.takeCard());
        player.hit(gamePack.takeCard());
        dealer.hit(gamePack.takeCard());
        dealer.showFirstCard();

        // Gamer turns
        while (true){
            player.showStatus();
            gamerChoice = player.whatToDoNext();
            if (gamerChoice.equals( "hit")){
                player.hit(gamePack.takeCard());
                if (player.calculatePoints() > 21){
                    showLoseMessage(player.calculatePoints());
                    break;
                } else if (player.calculatePoints() == 21){
                    showWinMessage(dealer.calculatePoints());
                    break;
                }
            } else {
                break;
            }
        }

        // Dealer turns
        int randomInt;
        while (player.calculatePoints()< 21){
            if (dealer.calculatePoints() <= 11){
                // always hit if less than 11 points
                dealer.hit(gamePack.takeCard());
            } else if (dealer.calculatePoints() <= 16){
                // randomly decides what to do, higher change to pass 1/3 change to take card, 2/3 to pass
                randomInt = (int)(Math.random()*3);
                if (randomInt == 0){
                    dealer.hit(gamePack.takeCard());
                    if (dealer.calculatePoints() > 21){

                    }
                } else{
                    break;
                }
            } else {
                break;
            }
        }

        // calculating winner
         if (player.calculatePoints()< 21){
             if (dealer.calculatePoints() > player.calculatePoints()){
                 showLoseMessage(player.calculatePoints());
             } else if (dealer.calculatePoints() < player.calculatePoints()) {
                 showWinMessage(dealer.calculatePoints());
             } else {
                 showLoseMessage(player.calculatePoints());
             }
         }
    }

    // Constructors for initting game, base difficulty = 1
    // TODO: implement difficulties (more than one cardpack)
    public BlackJack(int difficulty) {
        this.gamePack = new CardHolder(difficulty);
        gamePack.shuffle();
        this.player = new Player();
        this.dealer = new Dealer();
    }
    public BlackJack() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.gamePack = new CardHolder(1);
        gamePack.shuffle();
    }

    // Function rules() prints out the rules
    public static void showRules(){
        // TODO add rules
        System.out.println("There will be rules");
    }

    private void showLoseMessage(int playerPoints) {
        if (playerPoints > 21) {
            System.out.println("Sul on liiga palju punkte - " + player.calculatePoints());
        } else {
            System.out.println("Diiler sai rohkem punkte:" + dealer.calculatePoints() +
                    ", sul on aga ainult " + player.calculatePoints() + " punkti.");
        }
    }

    public static int readDifficultyInput() {
        String input;
        while (true){
            System.out.println("Sisesta raskustase (1-3): ");
            Scanner scan = new Scanner(System.in);
            input = scan.next();
            if (!input.equals("1") && !input.equals("2") && !input.equals("3")){
                System.out.println("Sisestatud raskustase on vigane.");
            } else {
                break;
            }
        }
        return Integer.parseInt(input);
    }

    private void showWinMessage(int dealerPoints) {
        if (dealerPoints > 21){
            System.out.println("Võitsid mängu, kuna diileril on liiga palju punkte - " + dealerPoints + ", sul on aga " + player.calculatePoints() + " punkti");
        } else {
            System.out.println("Võitsid mängu summaga " + player.calculatePoints() + ", tubli! Diileri punktid: " + dealer.calculatePoints());
        }
        // TODO add stats: wins and loses stats
    }


}
