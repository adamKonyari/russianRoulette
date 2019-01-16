import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Weapon type: ");
        int weaponType = scan.nextInt();
        System.out.print("Player count: ");
        int playerCount = scan.nextInt();
        System.out.print("Simulations: ");
        int simulations = scan.nextInt();
        HistoricalDatas generator = new HistoricalDatas();
        Simulation[] sims = new Simulation[simulations];
        for(int i = 0; i < simulations; i++) {
            sims[i] = new Simulation(weaponType, playerCount);
            generator.generateData(sims[i]);
        }
        scan.close();
        generator.load();
        Statistics stat = new Statistics();
        System.out.println(stat.ranking(stat.arrayBuilder("6", "3"))[1]);
    }
}
