package payment;

public class CardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Implement card payment processing logic here
        System.out.println("Processing card payment of amount: " + amount);
    }   
}
