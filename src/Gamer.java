import java.util.Scanner;

public class Gamer extends Hooman{
    public void showStatus(){
        //TODO : print card on hand
    }

    public String whatToDoNext(){
        String input;
        while (true){
            System.out.println("Mida teed järgmisena? Kui soovid võtta kaardi, siis kirjuta 'HIT', kui aga soovid jääda selle summaga, siis kirjuta 'PASS'");
            Scanner scan = new Scanner(System.in);
            input = scan.next();
            if (!input.toLowerCase().equals("hit") && !input.toLowerCase().equals("pass") ){
                System.out.println("Sisestatud tegevus on vigane.");
                continue;
            } else {
                break;
            }
        }
        return input;
    }
}
