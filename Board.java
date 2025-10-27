import java.util.ArrayList;

public class Board {

    private ArrayList<Fleet> fleets;

    public Board() {
        this.fleets = new ArrayList<>();
    }

    public void addFleet(Fleet fleet) {
        this.fleets.add(fleet);
    }

    public int toNorth() {
        int successfulMovements = 0;
        for (Fleet fleet : this.fleets) {
            try {
                fleet.moveNorth();
                successfulMovements++;
            } catch (BattleShipException e) {
            }
        }
        return successfulMovements;
    }

    public ArrayList<Fleet> infiltrated() throws BattleShipException {
        ArrayList<Fleet> infiltratedFleets = new ArrayList<>();
        for (Fleet fleet : this.fleets) {
            fleet.power(); 
            try {
                fleet.pilots();
            } catch (BattleShipException e) {
                infiltratedFleets.add(fleet);
            }
        }
        return infiltratedFleets;
    }

    public int power() throws BattleShipException {
        int totalPower = 0;
        int fleetsWithIssues = 0;
        int totalFleets = this.fleets.size();

        for (Fleet fleet : this.fleets) {
            try {
                totalPower += fleet.power();
            } catch (BattleShipException e) {
                fleetsWithIssues++;
            }
        }

        if (fleetsWithIssues > (totalFleets / 2.0)) {
            throw new BattleShipException("¡Falla crítica! Más de la mitad de las flotas (" + fleetsWithIssues + "/" + totalFleets + ") tienen problemas de poder.");
        }
        return totalPower;
    }
}