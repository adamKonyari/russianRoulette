import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;

public class HistoricalDatas{

    public void generateData(Simulation sim){

        File csvfile = new File("data.csv");
        String row = sim.getId() + "," + sim.getWeaponType() + "," + sim.getPlayerCount() + "," + sim.getDeadPlayer();
        PrintWriter out = null;
        try{
            if (csvfile.exists() && !csvfile.isDirectory()){
                out = new PrintWriter(new FileOutputStream(new File("data.csv"), true));
            }else{
                out = new PrintWriter("data.csv");
            }
            out.append(row + "\n");
            out.close();
        }catch(Exception e){
            System.out.println("File doesn't exist.");
        }
    }
}
