package bookingService;
import java.util.*;
public class BookingRepo {
    /**
     * This is a simple in-memory repository for storing bookings.
     */
    private List<Booking> bookings;
    public BookingRepo() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
