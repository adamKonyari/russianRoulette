import java.util.random;

public class Simulation {

    private int randomNumber;
    private int weaponType = 6;
    private int playerCount = 6;

    public Simulation(int weaponType, int playerCount) {
        this.weaponType = weaponType;
        this.playerCount = playerCount;
        Random generator = new Random();
        this.randomNumber = generator.nextInt(6) + 1;
    }
    public int getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(int weaponType) {
        this.weaponType = weaponType;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

}
