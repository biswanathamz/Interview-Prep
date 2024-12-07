import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Runnable Example

        System.out.println("Runnable Started");

        Runnable runnableDemoA = new RunnableDemo("A");
        Runnable runnableDemoB = new RunnableDemo("B");

        Thread thread1 = new Thread(runnableDemoA);
        Thread thread2 = new Thread(runnableDemoB);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Runnable Finished");

        //Callable Example

        System.out.println("Callable Started");

        Callable<Long> callable1 = new CallableDemo("A");
        Callable<Long> callable2 = new CallableDemo("B");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> res1 = executorService.submit(callable1);
        Future<Long> res2 = executorService.submit(callable2);

        executorService.shutdown();

        System.out.println("Callable Finished");
    }
}