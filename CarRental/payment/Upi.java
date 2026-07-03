package CarRental.payment;

public class Upi implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}
