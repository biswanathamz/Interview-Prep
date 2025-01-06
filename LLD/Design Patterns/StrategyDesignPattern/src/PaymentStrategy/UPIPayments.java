package PaymentStrategy;

public class UPIPayments implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("payment Through UPI");
    }
}
