import java.io.FileNotFoundException;
import java.util.Scanner;

//Наверн тут вся игра может быть. Сюда можно while прописать с hit() и pass()
public class BlackJack {
    private final CardHolder gamePack;
    private final Player player;
    private final Dealer dealer;
    private final Stats stats;

    public void start() throws FileNotFoundException {

        // Giving first cards
        player.hit(gamePack.takeCard());
        dealer.hit(gamePack.takeCard());
        player.hit(gamePack.takeCard());
        dealer.hit(gamePack.takeCard());
        dealer.showFirstCard();

        // Player turns
        playerTurns();

        // Dealer turns
        dealerTurns();

        // calculating winner
         if (player.calculatePoints()< 21 && dealer.calculatePoints() <= 21){
             if (dealer.calculatePoints() > player.calculatePoints()){
                 showLoseMessage(player.calculatePoints());
                 stats.addLose();
             } else if (dealer.calculatePoints() < player.calculatePoints()) {
                 showWinMessage(player.calculatePoints(), dealer.calculatePoints());
                 stats.addWin();
             } else {
                 showLoseMessage(player.calculatePoints());
                 stats.addLose();
             }
         }

         stats.showStats();
         stats.saveStats();

    }


    private void dealerTurns(){
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
                        showWinMessage(player.calculatePoints(), dealer.calculatePoints());
                        stats.addWin();
                    }
                } else{
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void playerTurns(){
        String gamerChoice;
        while (true){
            player.showStatus();
            gamerChoice = player.whatToDoNext();
            if (gamerChoice.equals( "hit")){
                player.hit(gamePack.takeCard());
                if (player.calculatePoints() > 21){
                    showLoseMessage(player.calculatePoints());
                    stats.addLose();
                    break;
                } else if (player.calculatePoints() == 21){
                    showWinMessage(player.calculatePoints(), dealer.calculatePoints());
                    stats.addWin();
                    break;
                }
            } else {
                break;
            }
        }
    }

    public BlackJack(int difficulty) throws Exception {
        this.gamePack = new CardHolder(difficulty);
        System.out.println("Kaardipakis on " + gamePack.size() + " kaarti.");
        gamePack.shuffle();
        this.player = new Player();
        this.dealer = new Dealer();
        this.stats = new Stats();
    }
    public BlackJack() throws Exception {
        this.player = new Player();
        this.dealer = new Dealer();
        this.gamePack = new CardHolder(1);
        gamePack.shuffle();
        this.stats = new Stats();
    }

    // Function rules() prints out the rules
    public static void showRules(){
        // TODO add rules
        System.out.println("Alustad BlackJack mänguga, reeglid on järgmised:\n" +
                "1) Mängu eesmärgiks on saada rohkem punkte kui diiler, kelle rolli täidab siin AI. Kui aga mängu käigus su punktid ületavad 21, siis sa kaotad. Kui mängu käigus saad sa täpselt 21 punkti, siis oled sa automaatselt määratud võitjaks\n" +
                "2) Punkte saab koguda kaartide abil. Mängu käesolevas versioonis on ainult 1 pakk, muidu saab neid olla ka rohkem\n" +
                "3) Kaardid 2 - 10 annavad vastavalt sama palju punkte, kui palju on kaardi peal kirjas. J, Q ja K annavad ka 10 punkti. A annab su enda valikul kas 1 või 11 punkti.\n" +
                "4) Mängu alguses saavad nii sina kui ka diiler 2 kaardi, diileri esimene kaart on nähtav. Seejärel on sul võimalik võtta kaarte juurde, nii palju kui soovi on.\n" +
                "5) Kui sa ei taha enam kaarte juurde võtta, siis tekib see võimalus diileril. Punkte arvutatakse siis, kui diiler ka ei soovi enam kaarte juurde võtta või juhtub midagi punktist 1");
    }

    private void showLoseMessage(int playerPoints) {
        if (playerPoints > 21) {
            System.out.println("Kaotus - sul on liiga palju punkte - " + player.calculatePoints());
        } else {
            System.out.println("Kaotus - diiler sai rohkem punkte:" + dealer.calculatePoints() +
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

    private void showWinMessage(int playerPoints, int dealerPoints) {
        if (playerPoints == dealerPoints ) {
            System.out.println("Viik - sul ja diileril on samapalju punkte - " + playerPoints);
        } else if (dealerPoints > 21) {
            System.out.println("Diiler võttis liiga palju kaarte ja nüüd tema punktisumma on " + dealerPoints + " punkti, sul aga " + playerPoints + " punkti. Tubli!");
        } else if (playerPoints < 21) {
            System.out.println("Sul on rohkem punkte, kui diileril, tubli! Sinu punktisumma - " + playerPoints + ", diileril aga -" + dealerPoints);
        }

    }

    // TODO add stats: wins and loses stats


}
