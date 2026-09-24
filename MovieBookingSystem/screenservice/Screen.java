package screenservice;
import seats.Seats;
import java.util.HashMap;
import java.util.Map;
public class Screen {
    private String screenId;
    private String screenName;
    Map<String, Seats> seats;
    public Screen(String screenName , String screenId) {
        this.screenName = screenName;
        this.screenId = screenId;
        this.seats = new HashMap<>();
    }
    
    public void addSeats(Seats seat){
        seats.put(seat.getSeatNumber(), seat);
    }
    public String getScreenName(){
        return screenName;
    }

    public Seats getSeat(String seatNumber){
        return seats.get(seatNumber);
    }

    public String getScreenId(){
        return screenId;
    }


    public String showavailableSeats(){
        StringBuilder availableSeats = new StringBuilder();
        for(Map.Entry<String, Seats> entry : seats.entrySet()){
            if(!entry.getValue().isBooked()){
                availableSeats.append(entry.getKey()).append(" ");
            }
        }
        return availableSeats.toString();
    }
}
