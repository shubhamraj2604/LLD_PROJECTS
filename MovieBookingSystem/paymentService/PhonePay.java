package paymentService;

public class PhonePay implements Payment {
    @Override
    public boolean pay(double amount) {
        // Implement PhonePe payment logic here
        System.out.println("Processing PhonePe payment of amount: " + amount);
        return true;
    }
}
