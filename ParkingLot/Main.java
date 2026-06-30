import vehcile.Vechile;
import vehcile.Car;
import vehcile.Bike;
import parkinglot.*;
import payment.PaymentFactory;

public class Main {
    public static void main(String[] args) {
      // Create instances of Car and Bike
        Vechile car = new Car("ABC123");
        Vechile bike = new Bike("XYZ789");

        // Display license plates and types
        System.out.println("Car License Plate: " + car.getLicensePlate());
        System.out.println("Car Type: " + car.getType());

        System.out.println("Bike License Plate: " + bike.getLicensePlate());
        System.out.println("Bike Type: " + bike.getType());


        // build the parking lot with 10 car slots and 5 bike slots
        ParkingLot parkingLot = ParkingLot.getInstance(10, 5);
        ParkingLot parkingLot1 = ParkingLot.getInstance(10, 25);
        System.out.println(parkingLot1 == parkingLot); // true, both references point to the same instance
        //park the car and bike
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);

        parkingLot.vacateSpot(car, "card");
        parkingLot.vacateSpot(bike, "cash");
    }
}