import seats.*;
import screenservice.Screen;
import java.time.LocalDateTime;
import bookingService.Booking;
import bookingService.BookingRepo;
import bookingService.BookingService;
import movieService.Movie;
import paymentService.CreditCardPayment;
import theatreService.Theatre;
import showservice.Show;
import user.User;

public class Main {
    public static void main(String[] args) {
        Seats s = new Recliner("s1", 250);
        System.out.println(s.getPrice());

        // s.bookedseat();
        System.out.println(s.isBooked());

        // add seats and simulate , test case:
        // Screen screen = new Screen("Screen 1", "S1");
        // Seats seat1 = new Recliner("R1", 250);
        // Seats seat2 = new Recliner("R2", 250);
        // Seats seat3 = new Regular("N1", 150);
        // screen.addSeats(seat1);
        // screen.addSeats(seat2);
        // screen.addSeats(seat3);
        // seat3.bookedseat();
        // System.out.println(screen.showavailableSeats());

        // simulate the test case as of the we have now
        Movie movie = new Movie("M1", "Inception", 148);

        Theatre theatre = new Theatre("PVR Cinemas", "T1");

        Screen screen = new Screen("Screen 1", "S1");
        screen.addSeats(new Recliner("R1", 250));
        screen.addSeats(new Recliner("R2", 250));
        screen.addSeats(new Regular("N1", 150));

        theatre.addScreens(screen);

        Show show = new Show(
                "SH1",
                movie,
                theatre,
                screen,
                LocalDateTime.of(2026, 9, 20, 18, 30));

        show.getShowDetails();

        System.out.println("Available seats: " + screen.showavailableSeats());

        BookingService bookingService = new BookingService(new BookingRepo());
        Booking booking = bookingService.createBooking(show, new User("U1", "Alice"), screen.getSeat("R1"));
        bookingService.confirmBooking(booking, new CreditCardPayment());

        System.out.println("Booking ID   : " + booking.getBookingId());
        System.out.println("Show ID      : " + booking.getShowId());
        System.out.println("User         : " + booking.getUsername());
        System.out.println("Seat         : " + booking.getSeatno());
        System.out.println("Amount       : " + booking.getAmount());
        System.out.println("Payment      : " + booking.getPaymentMethod());
        System.out.println("Available seats after booking: " + screen.showavailableSeats());

    }
}