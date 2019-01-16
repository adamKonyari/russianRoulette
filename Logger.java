import java.sql.Timestamp;
import java.util.Date;

public class Logger{

    public void log(String type, String message) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        System.out.println(ts + " " + type + " " + message);
    }

    public void arrayLog(int[] intArray) {
        for(int i = 0; i < intArray.length; i++) {
            System.out.println(i + 1 + ". " + intArray[i] + "%");
        }
    }
}
