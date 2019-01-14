public class Main {
    public static void main(String[] args) {
        Simulation asd = new Simulation(6, 6);
        HistoricalDatas generator = new HistoricalDatas();
        generator.generateData(asd);
    }
}
