package parkinglot;
import vehcile.*;
public abstract class ParkingSlot {
    private boolean isOccupied;
    private int spotNumber;
    private VechileType spotType;
    
    private Vechile vehcile;

    public ParkingSlot(int spotNumber, VechileType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }
    

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vechile getVechile() {
        return vehcile;
    }
    
     public int getSpotNumber() {
        return spotNumber;
    }
    // GET SPOT TYPE
    public VechileType getSpotType() {
        return spotType;
    }

    public abstract boolean canPark(Vechile vechile);
    
    public void park(Vechile vechile){
        isOccupied = true;
        this.vehcile = vechile;
    }

    public void vacate(){
        isOccupied = false;
        this.vehcile = null;
    }
}
