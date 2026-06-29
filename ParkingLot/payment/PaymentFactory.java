package payment;
public class PaymentFactory {
    public PaymentMethod getPaymentMethod(String paymentMethod) {
        if(paymentMethod.equalsIgnoreCase("card")){
            return new CardPayment();
        } else if(paymentMethod.equalsIgnoreCase("cash")){
            return new CashPayment();
        } else if(paymentMethod.equalsIgnoreCase("upi")){
            return new UpiPayment();
        }
        return null;
    }
}
