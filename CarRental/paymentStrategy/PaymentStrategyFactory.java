package CarRental.paymentStrategy;

import CarRental.car.*;
public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(CarType carType) {
        switch (carType) {
            case SEDAN:
                return new SedanStrategy();
            case SUV:
                return new SuvStrategy();
            case HATCHBACK:
                return new HatchBackStrategy();
            default:
                throw new IllegalArgumentException("Invalid car type: " + carType);
        }
    }
}
