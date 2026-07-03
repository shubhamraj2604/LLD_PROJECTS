package CarRental.payment;

public class DebitCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card.");
    }
    
}
