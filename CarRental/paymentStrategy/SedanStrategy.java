package CarRental.paymentStrategy;

public class SedanStrategy implements PaymentStrategy {
    @Override
    public double perCost() {
        return 30.0; // Cost per HOUR for Sedan
    }
    
}
