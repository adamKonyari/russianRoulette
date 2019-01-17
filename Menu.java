import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class Menu{

    public void menuPrinter() throws InterruptedException{

        
        int option;
        do{
            clearScreen();
            System.out.printf("Main Menu \n1. Try yourself in Russian Roulette \n2. I want to bet \n3. Statistics \n4. Check log file \n0. Exit");
            System.out.println("\nPlease select an option: ");
            Scanner menu = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            int weaponType;
            int playerCount;
            int simulations;
            Simulation[] sims;
            HistoricalDatas generator;
            Statistics stat;
            Logger logger;

            option = menu.nextInt();

            switch(option){
                case 1:
                    clearScreen();
                    System.out.print("Weapon type: ");
                    weaponType = scan.nextInt();
                    System.out.print("Player count: ");
                    playerCount = scan.nextInt();
                    System.out.print("Simulations: ");
                    simulations = scan.nextInt();
                    generator = new HistoricalDatas();
                    sims = new Simulation[simulations];
                    for(int i = 0; i < simulations; i++) {
                        sims[i] = new Simulation(weaponType, playerCount);
                        generator.generateData(sims[i]);
                    }
                    generator.load("data.csv");
                    stat = new Statistics();
                    logger = new Logger();
                    logger.arrayLog((stat.ranking(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))));
                    System.out.printf("Please take your seat (1 - %s): ", playerCount);
                    int input = scan.nextInt();
                    Simulation finalSim = new Simulation(weaponType, playerCount);
                    if(input == finalSim.getDeadPlayer()) {
                        System.out.println("\nYOU DIED");
                        Thread.sleep(3000);
                    } else {
                        System.out.println("\nYou've survived!");
                        Thread.sleep(3000);
                    }
                    generator.clearContent();
                    break;

                case 2:
                    clearScreen();
                    generator = new HistoricalDatas();
                    System.out.print("Weapon type: ");
                    weaponType = scan.nextInt();
                    System.out.print("Player count: ");
                    playerCount = scan.nextInt();
                    /*System.out.print("Simulations: ");
                    simulations = scan.nextInt();
                    sims = new Simulation[simulations];
                    for(int i = 0; i < simulations; i++) {
                        sims[i] = new Simulation(weaponType, playerCount);
                        generator.generateData(sims[i]);
                    }*/
                    generator.load("permanentData.csv");
                    stat = new Statistics();
                    logger = new Logger();
                    logger.arrayLog((stat.ranking(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))), (stat.odds(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))));
                    System.out.printf("Place your bet (1 - %s): ", playerCount);
                    int bet = scan.nextInt();
                    Simulation betSim = new Simulation(weaponType, playerCount);
                    int deadPlayerNum = betSim.getDeadPlayer();
                    if(bet == deadPlayerNum) {
                        System.out.println("\nYOU WON");
                        Thread.sleep(3000);
                    } else {
                        System.out.printf("\nYou lost! The %s. player died in this round.", deadPlayerNum);
                        Thread.sleep(3000);
                    }
                    break;
                case 3:
                clearScreen();
                System.out.println("Not implemented");
                Thread.sleep(1500);
                break;
                case 4:
                clearScreen();
                System.out.println("Not implemented");
                Thread.sleep(1500);
                break;
                case 0:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid options");
            }

        } while(option != 0);



    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 


}
