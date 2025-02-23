package ClientType;

import PaymentStrategy.PaymentStrategy;

public class OverseasClient implements ClientType{
    PaymentStrategy paymentStrategy;

    @Override
    public void paymentMode(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void payment(double amount){
        this.paymentStrategy.pay(amount);
    }
}
