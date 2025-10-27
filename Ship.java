import java.util.ArrayList;

public class Ship extends Machine {

    protected ArrayList<Sailor> sailors;

    public Ship(int longitude, int latitude) {
        super(longitude, latitude);
        this.sailors = new ArrayList<>();
    }

    public void addSailor(Sailor sailor) {
        this.sailors.add(sailor);
    }

    public ArrayList<Sailor> getSailors() {
        return sailors;
    }

    @Override
    public boolean isWeak() {
        return this.sailors.size() < 2;
    }

    @Override
    public ArrayList<Sailor> getPilots() throws BattleShipException {
        return new ArrayList<Sailor>();
    }

    @Override
    public int getSailorCount() {
        return this.sailors.size();
    }
}