package bookingService;
import showservice.Show;
import user.User;
import seats.*;

import java.time.LocalDateTime;

import paymentService.*;
public class Booking {
    private String bookingId;
    private String showId;
    private String username;
    private String seatno;
    private double amount;
    private PaymentStatus paymentStatus;
    private BookingStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    public Booking(String bookingId, String showId, String username, String seatno, double amount, PaymentStatus paymentsStatus) {
        this.bookingId = bookingId;
        this.showId = showId;
        this.username = username;
        this.seatno = seatno;
        this.amount = amount;
        this.paymentStatus = paymentsStatus;
        this.status = BookingStatus.CREATED;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = createdAt.plusHours(1);
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getShowId(){
        return showId;
    }

    public String getUsername(){
        return username;
    }

    public String getSeatno(){
        return seatno;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentMethod() {
        return paymentStatus;
    }

    public void changepaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }
}