package parkinglot;
import java.util.*;
import vehcile.*;
import payment.*;
import parkingticket.*;
public class ParkingLot {

    private static ParkingLot instance;
     // singleton pattern to ensure only one instance of ParkingLot exists
     // synchronized method to make it thread-safe
    public static synchronized ParkingLot getInstance(int carSlots, int bikeSlots) {
        if (instance == null) {
            instance = new ParkingLot(carSlots, bikeSlots);
        }
        return instance;
    }
    private List<ParkingSlot> parkingSpots  = new ArrayList<>();
    private HashMap<Integer, ParkingTicket> parkingTickets = new HashMap<>();
    private int totalSlots , carSlots , bikeSlots;
    public ParkingLot(int carSlots , int bikeSlots) {
        this.carSlots = carSlots;
        this.bikeSlots = bikeSlots;
        totalSlots = carSlots + bikeSlots;
        
        for(int i=0;i<carSlots;i++){
            ParkingSlot carSpot = new carParkingSpot(i+1);
            parkingSpots.add(carSpot);
        }
        for(int i=carSlots;i<totalSlots;i++){
            ParkingSlot bikeSpot = new BikeParkingSpot(i+1);
            parkingSpots.add(bikeSpot);
        }
    }


    public int getCarSlots() {
        return carSlots;
    }

    public int getBikeSlots() {
        return bikeSlots;
    }

    public ParkingSlot findAvailableSpot(VechileType v){
        for(ParkingSlot c: parkingSpots){
              if(c.getSpotType() == v && c.isOccupied() == false){
                  return c;
              }
        }
        return null;
    }

    public ParkingSlot findVechileSpot(Vechile v){
        for(ParkingSlot c: parkingSpots){
              if(c.getVechile() == v){
                 return c;
              }
        }
        return null;
    }
    
    
    public void parkVehicle(Vechile vechile){
        ParkingSlot availableSpot = findAvailableSpot(vechile.getType());
        if(availableSpot != null){
            availableSpot.park(vechile);
            System.out.println("Vehicle parked at spot number: " + availableSpot.getSpotNumber());
        } else {
            System.out.println("No available parking spot for vehicle type: " + vechile.getType());
        }
    }


    public void vacateSpot(Vechile vechile , String paymentMethod){
        ParkingSlot vechileSpot = findVechileSpot(vechile);

        if(vechileSpot != null){
            //payment
            PaymentMethod payment = new PaymentFactory().getPaymentMethod(paymentMethod);
            // payment.processPayment(100); // Assuming a fixed amount for simplicity   
            vechileSpot.vacate();
            System.out.println("Vehicle is exiting the parking lot");
            System.out.println("Thank you, Visit again");
        }else{
            System.out.println("This vehicle is not parked in the parking lot");
        }
    }
}
