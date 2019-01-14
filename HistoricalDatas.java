import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

public class HistoricalDatas {
    public void generateData(Simulation sim) {
        try {
            PrintWriter pw = new PrintWriter(new File("data.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append(sim.getId());
            sb.append(',');
            sb.append(sim.getWeaponType());
            sb.append(',');
            sb.append(sim.getPlayerCount());
            sb.append(',');
            sb.append(sim.getDeadPlayer());
            sb.append('\n');
            pw.write(sb.toString());
            pw.close();
        } catch(FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

}
