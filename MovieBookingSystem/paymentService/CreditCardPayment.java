package paymentService;

public class CreditCardPayment implements Payment {
    @Override
    public boolean pay(double amount) {
        // Implement credit card payment logic here
        System.out.println("Processing credit card payment of amount: " + amount);
        return true;
    }
    
}
