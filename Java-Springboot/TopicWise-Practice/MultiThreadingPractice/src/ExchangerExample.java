import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public void exchangeData(Exchanger<String> exchanger, String message, String dataToSend){
        try {
            System.out.println(message+" : "+dataToSend);
            String data = exchanger.exchange(dataToSend);
            System.out.println(message+" : Received - "+data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void demo(){
        Exchanger<String> exchanger = new Exchanger<>();
        Thread thread1 = new Thread(()->{
            exchangeData(exchanger,"Thread 1 sending data","Data from thread 1");
        });
        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(3000);
                exchangeData(exchanger,"Thread 2 sending data","Data from thread 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            System.out.println("Exchange operation finished!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
