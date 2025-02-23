package ClientType;

import PaymentStrategy.PaymentStrategy;

public interface ClientType {
    void paymentMode(PaymentStrategy paymentStrategy);
    void payment(double amount);
}
