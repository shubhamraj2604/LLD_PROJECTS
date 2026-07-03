package CarRental.bookingsytem;

import java.util.*;
import java.time.LocalDateTime;
import CarRental.location.Location;
import CarRental.user.User;
import CarRental.booking.*;
import CarRental.car.*;
import CarRental.payment.*;
import CarRental.paymentStrategy.*;

public class BookingSystem {
    private Map<String, Location> locations = new HashMap<>();
    List<Booking> bookings = new ArrayList<>();
    public BookingSystem() {
    }

    public void createUser(String name, String age) {
        // create user
        User user = new User(name, age);
        System.out.println("User created successfully: " + user.getName() + ", Age: " + user.getAge());
        return;
    }

    public void addLocation(Location location) {
        locations.put(location.getName(), location);
    }

    public Booking bookCar(User user, String locationName, CarType carType) {

        // Find the location
        Location location = locations.get(locationName);
        if (location == null) {
            System.out.println("Location does not exist.");
            return null;
        }

        // Find an available car
        Car car = location.getCar(carType);
        if (car == null) {
            System.out.println("No " + carType + " available at " + locationName);
            return null;
        }
        // Book the car
        car.setStatus(CarStatus.BOOKED);
        // Create booking
        Booking booking = new Booking(user, car, location, java.time.LocalDateTime.now());
        bookings.add(booking);
        System.out.println("Booking successful!");
        // I WILL RETURN THIS BOOKING SO THAT I CAN USE IT TO RETURN THE CAR LATER
        return booking;
    }

    public void returnCar(Location location, Car car , Booking booking , Payment payment , LocalDateTime dropTime) {
        // check if location exists
        if (!locations.containsValue(location)) {
            System.out.println("Location does not exist");
            return;
        }
        if (car.getStatus() != CarStatus.BOOKED) {
            System.out.println("Car is not booked");
            return;
        }
        // return the car
        // calculate the time
        int hours = booking.calculateTime(dropTime);
        System.out.println("Total hours: " + hours);
        if (hours == -1) {
            return;
        }
        // calculate the cost

        double cost = hours * PaymentStrategyFactory.getPaymentStrategy(car.getCarType()).perCost();
        payment.pay(cost);
        System.out.println("Car returned successfully. Total cost: " + cost);
        car.setStatus(CarStatus.AVAILABLE);
        booking.setBookingStatus(BookingStatus.COMPLETED);
    }
}
