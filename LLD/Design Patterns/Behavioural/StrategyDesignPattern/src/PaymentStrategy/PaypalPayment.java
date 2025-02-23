package PaymentStrategy;

public class PaypalPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("payment Through Paypal");
    }
}
