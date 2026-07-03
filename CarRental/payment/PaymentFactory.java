package CarRental.payment;

public class PaymentFactory {
    public static Payment getPaymentMethod(String paymentType) {
        if (paymentType == null) {
            return null;
        }
        if (paymentType.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCardPayment();
        } else if (paymentType.equalsIgnoreCase("DEBITCARD")) {
            return new DebitCard();
        } else if (paymentType.equalsIgnoreCase("UPI")) {
            return new Upi();
        }
        return null;
    }
}
