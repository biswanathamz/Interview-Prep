import Services.Impl.TransactionImpl;
import Services.Transaction;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new TransactionImpl();
        transaction.sendMoney("indian",4321);
        transaction.sendMoney("indian",5645);
        transaction.sendMoney("dubai",2345);
        transaction.sendMoney("indian",1254.545);
    }
}