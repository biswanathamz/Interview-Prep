package PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("payment Through CreditCard");
    }
}
