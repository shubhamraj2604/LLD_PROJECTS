package CarRental.booking;
import CarRental.user.*;
import CarRental.location.*;

import java.time.LocalDateTime;

import CarRental.car.*;
public class Booking {
    private User user;
    private Car car;
    Location pickuplLocation;
    LocalDateTime pickupTime;
    LocalDateTime droptime;
    BookingStatus bookingStatus;
    
    public Booking(User user , Car car ,Location pickupLocation , LocalDateTime pickupTime){
        this.user = user;
        this.car = car;
        this.pickuplLocation = pickupLocation;
        this.pickupTime = pickupTime;
        this.bookingStatus = BookingStatus.BOOKED;
    }

    public User getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    public int calculateTime(LocalDateTime droptime){
        if(droptime == null){
            System.out.println("Car has not been returned yet");
            return -1;
        }
        int hours = java.time.Duration.between(pickupTime, droptime).toHoursPart();
        return hours;
    }
}
