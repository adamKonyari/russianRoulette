import java.util.Scanner;
import java.io.File;

public class Menu{

    public void menuPrinter(){

        System.out.printf("Main Menu \n1. I want to run a simulation \n2. I want to bet \n3. Statistics \n4. Check log file \n0. exit");
        int option;
        do{
            System.out.println("\nGive a number");
            Scanner menu = new Scanner(System.in);
            option = menu.nextInt();

            switch(option){
                case 1:
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
                generator.load();
                Statistics stat = new Statistics();
                Logger logger = new Logger();
                logger.arrayLog((stat.ranking(stat.arrayBuilder(Integer.toString(weaponType), Integer.toString(playerCount)))));
                break;
                case 2:
                System.out.println("not implemented");
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
