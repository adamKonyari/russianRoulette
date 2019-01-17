import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class HistoricalDatas {

    Simulation[] simulations;

    public void generateData(Simulation sim) {

        File csvFile = new File("data.csv");
        String row = sim.getId() + "," + sim.getWeaponType() + "," + sim.getPlayerCount() + "," + sim.getDeadPlayer();
        PrintWriter out = null;
        PrintWriter out2 = null;
        try {
            if (csvFile.exists() && !csvFile.isDirectory()) {
                out = new PrintWriter(new FileOutputStream(new File("data.csv"), true));
                out2 = new PrintWriter(new FileOutputStream(new File("permanentData.csv"), true));
            } else {
                out = new PrintWriter("data.csv");
            }
            out.append(row + "\n");
            out2.append(row + "\n");
            out.close();
            out2.close();
            csvFile.deleteOnExit();
        } catch(Exception e) {
            System.out.println("File doesn't exist.");
        }
    }

    public int lineCounter(String file) {
        int counter = 0;
        try {
            File csvFile = new File(file);
            Scanner scan = new Scanner(csvFile);

            while(scan.hasNextLine()) {
                counter++;
                scan.nextLine();
            }
            scan.close();
            return counter;

        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            return counter;
        }
    }

    public void load(String filename) {
        try {
            simulations = new Simulation[lineCounter(filename)];
            File csvFile = new File(filename);
            Scanner scan = new Scanner(csvFile);
            int i = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                Simulation simulation = new Simulation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                simulations[i] = simulation;
                i++;
            } scan.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Oops, file not found!");
            System.exit(0);
        }
    }


    public void clearContent() {
        try {
            FileWriter fw = new FileWriter("data.csv", false);
            fw.close();
        } catch(Exception e) {
            System.out.println("Exception occured.");
        }
    }
}
