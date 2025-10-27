import java.util.ArrayList;

public class Plane extends Machine {

    private String plate;
    private boolean inAir;
    private Sailor pilot;
    private Sailor copilot;

    public Plane(String plate, int longitude, int latitude, Sailor pilot, Sailor copilot) {
        super(longitude, latitude);
        this.plate = plate;
        this.pilot = pilot;
        this.copilot = copilot;
        this.inAir = false; 
    }
    
    public Sailor getPilot() {
        return pilot;
    }

    @Override
    public boolean isWeak() {
        return this.pilot == null;
    }

    @Override
    public ArrayList<Sailor> getPilots() throws BattleShipException {
        ArrayList<Sailor> list = new ArrayList<>();
        if (pilot != null) list.add(pilot);
        if (copilot != null) list.add(copilot);
        return list;
    }

    @Override
    public int getSailorCount() {
        int count = 0;
        if (pilot != null) count++;
        if (copilot != null) count++;
        return count;
    }
}