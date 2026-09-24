package seats;

public class Recliner extends Seats {
     public Recliner(String seatNumber, double price) {
         super(seatNumber, price);
     }

     public SeatType getSeatType(){
        return SeatType.Recliner;
     }
}
