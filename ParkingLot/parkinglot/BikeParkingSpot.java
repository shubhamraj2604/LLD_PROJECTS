package parkinglot;

import vehcile.Vechile;
import vehcile.*;
public class BikeParkingSpot extends ParkingSlot {

    BikeParkingSpot(int spotNumber){
        super(spotNumber , VechileType.BIKE);
    }


    public boolean canPark(Vechile vechile){
        return vechile.getType() == VechileType.BIKE;
    }

}
