package payment;

public class CashPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Implement cash payment processing logic here
        System.out.println("Processing cash payment of amount: " + amount);
    }
    
}
