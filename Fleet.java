import java.util.ArrayList;

public class Fleet {

    private int name;
    private ArrayList<Machine> machines;

    public Fleet(int name) {
        this.name = name;
        this.machines = new ArrayList<>();
    }

    public void addMachine(Machine machine) {
        this.machines.add(machine);
    }

    public void Advance(int dlon, int dlat) {
        for (Machine machine : machines) {
            machine.advance(dlon, dlat); 
        }
    }

    public ArrayList<Machine> willBeDestroyed(int longitude, int latitude) {
        ArrayList<Machine> affectedMachines = new ArrayList<>();
        final double BLAST_RADIUS = 10.0;

        for (Machine machine : machines) {
            Position pos = machine.getLocation();
            
            double distance = Math.sqrt(
                Math.pow(pos.getLongitude() - longitude, 2) +
                Math.pow(pos.getLatitude() - latitude, 2)
            );

            if (distance <= BLAST_RADIUS) {
                affectedMachines.add(machine);
            }
        }
        return affectedMachines;
    }

    public ArrayList<Machine> weakMachines() {
        ArrayList<Machine> weakList = new ArrayList<>();
        for (Machine machine : machines) {
            if (machine.isWeak()) {
                weakList.add(machine);
            }
        }
        return weakList;
    }

    public boolean isGoodAtack(int longitude, int latitude) {
        return this.willBeDestroyed(longitude, latitude).isEmpty();
    }

    public void atack(int longitude, int latitude) {
        for (Machine machine : machines) {
            
            if (!machine.isWeak()) {
                Position pos = machine.getLocation();
                
                int dlon = Integer.compare(longitude, pos.getLongitude());
                int dlat = Integer.compare(latitude, pos.getLatitude());

                machine.advance(dlon, dlat);
            }
        }
    }

    public void moveNorth() throws BattleShipException {
        try {
            for (Machine machine : machines) {
                machine.moveNorth(); 
            }
        } catch (BattleShipException e) {
            throw new BattleShipException("Movimiento al norte fallido: " + e.getMessage());
        }
    }

    public ArrayList<Sailor> pilots() throws BattleShipException {
        ArrayList<Sailor> allPilots = new ArrayList<>();
        
        for (Machine machine : machines) {
            try {
                allPilots.addAll(machine.getPilots());
            } catch (BattleShipException e) {
                throw new BattleShipException("Piloto infiltrado detectado: " + e.getMessage());
            }
        }
        return allPilots;
    }

    public int power() throws BattleShipException {
        int totalSailors = 0;
        int totalMachines = machines.size();
        int powerCount = 0; 

        for (Machine machine : machines) {
            totalSailors += machine.getSailorCount();
            if (!machine.isWeak()) {
                powerCount++;
            }
        }

        if (totalSailors < totalMachines) {
            throw new BattleShipException("Poder insuficiente, Hay menos marinos (" + totalSailors +") que máquinas (" + totalMachines + ").");
        }
        return powerCount;
    }
}