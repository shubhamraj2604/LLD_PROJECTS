package parkinglot;

import vehcile.*;
public class carParkingSpot extends ParkingSlot {

     public carParkingSpot(int spotNumber){
        super(spotNumber, VechileType.CAR);
     }
     public boolean canPark(Vechile vechile){
        return vechile.getType() == VechileType.CAR;
     }
}
