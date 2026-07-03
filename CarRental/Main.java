package CarRental;

import java.time.LocalDateTime;

import CarRental.booking.*;
import CarRental.bookingsytem.*;
import CarRental.car.*;
import CarRental.location.*;
import CarRental.payment.*;
import CarRental.user.*;

public class Main {
    public static void main(String[] args) {
        // Create a booking system
        BookingSystem bookingSystem = new BookingSystem();

        // Create locations
        Location location1 = new Location("Delhi", "110059");
        Location location2 = new Location("Mumbai", "400001");

        // Add locations to the booking system
        bookingSystem.addLocation(location1);
        bookingSystem.addLocation(location2);

        // Create cars
        Car car1 = new Car("Toyota Camry", CarType.SEDAN);
        Car car2 = new Car("Honda CR-V", CarType.SUV);
        Car car3 = new Car("Ford Focus", CarType.HATCHBACK);

        // Add cars to locations
        location1.addCar(car1);
        location1.addCar(car2);
        location2.addCar(car3);

        // Create users
        User user1 = new User("Alice", "30");
        User user2 = new User("Bob", "25");

        // Book cars for users
        Booking b1 = bookingSystem.bookCar(user1, "Delhi", CarType.SEDAN);
        Booking b2 = bookingSystem.bookCar(user2, "Mumbai", CarType.HATCHBACK);

        Payment payment1 = PaymentFactory.getPaymentMethod("CREDITCARD");

        // Return cars
        LocalDateTime returnTime = LocalDateTime.parse("2026-07-03T17:30:00").plusHours(0);
        

        bookingSystem.returnCar(
                location1,
                car1,
                b1,
                payment1,
                returnTime);
    }
}
