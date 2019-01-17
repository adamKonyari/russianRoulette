import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Statistics {

    public Simulation[] arrayBuilder(String weaponType, String playerCount) {
        Simulation[] permanentData = new Simulation[lineCounter("permanentData.csv", weaponType, playerCount)];
        try {
            File csvFile = new File("permanentData.csv");
            Scanner scan = new Scanner(csvFile);
            int i = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                if(parts[1].equals(weaponType) && parts[2].equals(playerCount)) {
                    Simulation simulation = new Simulation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    permanentData[i] = simulation;
                    i++;
                }

            }
            scan.close();
            return permanentData;
        } catch(FileNotFoundException ex) {
            System.out.println("Oops, file not found!");
            return permanentData;
        }
    }

    public int lineCounter(String file, String weaponType, String playerCount) {
        int counter = 0;
        try {
            File csvFile = new File(file);
            Scanner scan = new Scanner(csvFile);

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                if(parts[1].equals(weaponType) && parts[2].equals(playerCount)) {
                    counter++;
                }
            }
            scan.close();
            return counter;

        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            return counter;
        }
    }

    public int[] ranking(Simulation[] sim){

        int[] result = new int[sim[0].getPlayerCount()];
        int[] percent = new int[result.length];
        
        for(Simulation s: sim){
            result[s.getDeadPlayer() - 1] += 1;
        }
        for(int i = 0; i < result.length; i++){
            double res = result[i];
            double siml = sim.length;
            double x = (res / siml) * 100;
            percent[i] = (int) x;
        }
        return percent;

    }

}
