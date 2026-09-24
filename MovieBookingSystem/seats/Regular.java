package seats;

public class Regular extends Seats {
    public Regular(String seatNumber , double cost){
        super(seatNumber , cost);
    }

    public SeatType getSeatType(){
        return SeatType.Regular;
    }
}
