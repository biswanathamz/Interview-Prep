package ClientType;

import PaymentStrategy.PaymentStrategy;

public class IndianClient implements ClientType{
    PaymentStrategy paymentStrategy;
    @Override
    public void paymentMode(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void payment(double amount) {
        this.paymentStrategy.pay(amount);
    }
}
