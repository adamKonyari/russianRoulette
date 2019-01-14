import java.util.random;

public class Simulation {

    private int randomNumber;
    private int weaponType = 6;
    private int playerCount = 6;
    private int deadPlayer;

    public Simulation(int weaponType, int playerCount) {
        this.weaponType = weaponType;
        this.playerCount = playerCount;
        Random generator = new Random();
        this.randomNumber = generator.nextInt(weaponType) + 1;

        int mod = randomNumber % playerCount;

        if(weaponType == playerCount) {
            deadPlayer = randomNumber;
        } else {
            if(randomNumber > playerCount && mod != 0) {
                deadPlayer = randomNumber % playerCount;
            } else if(randomNumber > playerCount && mod = 0) {
                deadPlayer = playerCount;
            } else {
                deadPlayer = randomNumber;
            }
        }
    }

    public int getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(int newWeaponType) {
        this.weaponType = newWeaponType;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int newPlayerCount) {
        this.playerCount = newPlayerCount;
    }
}
