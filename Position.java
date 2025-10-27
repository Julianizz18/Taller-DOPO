public class Position {
    private int longitude;
    private int latitude;

    public Position(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude() { 
        return longitude; 
    }
    
    public int getLatitude() {
        return latitude; 
    }

    public void setLon(int lon) {
         this.longitude = lon; 
    }

    public void setLat(int lat) { 
        this.latitude = lat; 
    }
}