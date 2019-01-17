import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Menu{

    public void menuPrinter(){

        System.out.printf("Main Menu \n1. Try yourself in Russian Roulette \n2. I want to bet \n3. Statistics \n4. Check log file \n0. Exit");
        int option;
        do{
            System.out.println("\nGive a number");
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
                    generator.load();
                    stat = new Statistics();
                    logger = new Logger();
                    logger.arrayLog((stat.ranking(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))));
                    System.out.printf("Please take your seat (1 - %s): ", playerCount);
                    int input = scan.nextInt();
                    Simulation finalSim = new Simulation(weaponType, playerCount);
                    if(input == finalSim.getDeadPlayer()) {
                        System.out.println("YOU DIED");
                    } else {
                        System.out.println("You've survived!");
                    }
                    generator.clearContent();
                    break;

                case 2:
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
                    generator.load();
                    stat = new Statistics();
                    logger = new Logger();
                    logger.arrayLog((stat.ranking(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))), (stat.odds(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))));
                    break;
                case 3:
                System.out.println("not implemented");
                break;
                case 4:
                System.out.println("not implemented");
                break;
                case 0:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid options");
            }

        } while(option != 0);



    }




}
