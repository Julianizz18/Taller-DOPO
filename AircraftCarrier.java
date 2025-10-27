import java.util.ArrayList;

public class AircraftCarrier extends Ship {

    private int number;
    private int capacity;
    private ArrayList<Plane> airPlanes;

    public AircraftCarrier(int number, int capacity, int longitude, int latitude) {
        super(longitude, latitude);
        this.number = number;
        this.capacity = capacity;
        this.airPlanes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        if (airPlanes.size() < capacity) {
            airPlanes.add(plane);
        }
    }
    
    public ArrayList<Plane> getAirPlanes() {
        return airPlanes;
    }

    @Override
    public boolean isWeak() {
        boolean weakAsShip = super.isWeak(); 
        boolean noPlanes = this.airPlanes.isEmpty();
        return weakAsShip || noPlanes;
    }

    @Override
    public ArrayList<Sailor> getPilots() throws BattleShipException {
        ArrayList<Sailor> allPilots = new ArrayList<>();
        
        for (Plane plane : airPlanes) {
            ArrayList<Sailor> planePilots = plane.getPilots();
            
            for (Sailor pilot : planePilots) {
                if (!this.sailors.contains(pilot)) {
                    throw new BattleShipException("Piloto infiltrado detectado: " + pilot.getName());
                }
                allPilots.add(pilot);
            }
        }
        return allPilots;
    }

    @Override
    public int getSailorCount() {
        int total = super.getSailorCount(); 
        for (Plane plane : airPlanes) {
            total += plane.getSailorCount(); 
        }
        return total;
    }
}