package parkingticket;
import parkinglot.ParkingSlot;

import java.time.*;
import java.util.*;
import vehcile.*;
public class ParkingTicket {
    private int ticketId;
    private LocalDateTime inTime;
    private Vechile vechile;
    private ParkingSlot parkingSlot;
    private LocalDateTime exitTime;


    public ParkingTicket(int ticketId , LocalDateTime inTime , Vechile vechile , ParkingSlot parkingSlot){
        this.ticketId = ticketId;
        this.inTime = inTime;
        this.vechile = vechile;
        this.parkingSlot = parkingSlot;
        exitTime = null;
    }
   
    public void setExitTime(){
        this.exitTime = exitTime;
    }
    
    public long calculatePrice(){
        long minutes = Duration.between(inTime, exitTime).toMinutes();
        return minutes * 2;
    }

}
