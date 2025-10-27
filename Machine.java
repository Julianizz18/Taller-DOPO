import java.util.ArrayList;

public abstract class Machine {

    protected Position location;

    public Machine(int longitude, int latitude) {
        this.location = new Position(longitude, latitude);
    }

    public Position getLocation() {
        return location;
    }

    public void advance(int dlon, int dlat) {
        int newLat = this.location.getLatitude() + dlat;
        if (newLat > 90) newLat = 90;
        else if (newLat < -90) newLat = -90;
        this.location.setLat(newLat);

        int newLon = this.location.getLongitude() + dlon;
        while (newLon > 180) newLon -= 360; 
        while (newLon < -180) newLon += 360;
        this.location.setLon(newLon);
    }

    public void moveNorth() throws BattleShipException {
        if (this.location.getLatitude() == 90) {
            throw new BattleShipException("No se puede mover, ya está en el Polo Norte.");
        } else {
            this.advance(0, 1);
        }
    }
}