import ClientType.*;
import PaymentStrategy.*;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy upi = new UPIPayments();
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy paypal = new PaypalPayment();


        CreditCardClient creditCardClient = new CreditCardClient();
        ClientType UPIClient = new UPIClient();
        ClientType indianClient = new IndianClient();
        ClientType OverseasClient = new OverseasClient();

        creditCardClient.paymentMode(creditCardPayment);
        indianClient.paymentMode(creditCardPayment);
        UPIClient.paymentMode(upi);
        OverseasClient.paymentMode(paypal);

        creditCardClient.payment(100);
        creditCardClient.payment(200);
        UPIClient.payment(200.60);
        OverseasClient.payment(500);
    }
}