import java.util.ArrayList;

public class Submarine extends Machine {
    
    public Submarine(int longitude, int latitude) {
        super(longitude, latitude);
    }
    
    @Override
    public boolean isWeak() {
        return false;
    }

    @Override
    public ArrayList<Sailor> getPilots() throws BattleShipException {
        return new ArrayList<Sailor>();
    }

    @Override
    public int getSailorCount() {
        return 0;
    }
}