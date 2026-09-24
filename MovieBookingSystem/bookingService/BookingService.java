package bookingService;

import paymentService.Payment;
import paymentService.PaymentStatus;
import seats.Seats;
import showservice.Show;
import user.User;

public class BookingService {
     private final BookingRepo bookingRepo;
     public BookingService(BookingRepo bookingRepo){
        this.bookingRepo = bookingRepo;
     }

     // create booking
     public Booking createBooking(Show show , User user , Seats seats){
           double amount = seats.getPrice();
           Booking booking = new Booking("1", show.getShowId(), user.getName(), seats.getSeatNumber(), amount, PaymentStatus.PENDING);
           bookingRepo.addBooking(booking);
           seats.bookedseat();
           return booking;
     }

     // confirm booking
     public void confirmBooking(Booking booking , Payment payment){
        double amount = booking.getAmount();
        if(payment.pay(amount) == false){
            System.out.println("Payment not successful");
            booking.changepaymentStatus(PaymentStatus.FAILED);
            return ;
        }
        booking.changepaymentStatus(PaymentStatus.SUCCESS);
     }
}
