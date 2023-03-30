import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Stats {
    private String name;
    private int wins = 0;
    private int loses = 0;
    private String fileName = "stats.txt";

    public Stats() throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            List<String> read = Files.readAllLines(Paths.get(fileName));
            String[] parts = read.get(0).split(";");
            if (parts[0].equals(System.getProperty("user.name") )){
                this.wins = Integer.parseInt(parts[1]);
                this.loses = Integer.parseInt(parts[2]);
            }
        }

        this.name = System.getProperty("user.name");
    }

    public void showStats(){
        System.out.println("Mängijal " + name + " on " + wins + " võitu ja " + loses + " kaotust.");
    }

    public void saveStats() throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter writer = new PrintWriter(file);
        writer.print(name + ";" + wins + ";" + loses);
        writer.close();
    }

    public void addWin(){
        wins += 1;
    }

    public void addLose(){
        loses += 1;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
    }
}
