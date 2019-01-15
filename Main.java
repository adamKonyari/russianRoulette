public class Main {
    public static void main(String[] args) {
        HistoricalDatas generator = new HistoricalDatas();
        Simulation[] sims = new Simulation[10];
        for(int i = 0; i < 10; i++) {
            sims[i] = new Simulation(3, 2);
            generator.generateData(sims[i]);
        }

        generator.load();
    }
}
