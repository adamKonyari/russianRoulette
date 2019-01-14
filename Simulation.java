import java.util.random;

public class Simulation {

    public int Simulation() {
        Random generator = new Random();
        return generator.nextInt(6) + 1;
    }
}
