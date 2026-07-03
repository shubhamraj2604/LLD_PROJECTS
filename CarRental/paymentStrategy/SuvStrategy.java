package CarRental.paymentStrategy;

public class SuvStrategy implements PaymentStrategy {
    @Override
    public double perCost() {
        return 50.0; // Cost per HOUR for SUV
    }
}
