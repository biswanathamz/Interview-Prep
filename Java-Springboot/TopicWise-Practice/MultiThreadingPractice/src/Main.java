import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Runnable Example

//        System.out.println("Runnable Started");
            // Using Traditional Approach
//            Thread thread1 = new Thread(new RunnableDemo(1));
//            Thread thread2 = new Thread(new RunnableDemo(2));
//
//            thread1.start();
//            thread2.start();
//
//            thread1.join();
//            thread2.join();

            // Using Executor Approach
//            ExecutorService executors = Executors.newFixedThreadPool(2);
//            for (int i=0; i<10; i++){
//                executors.execute(new RunnableDemo(i));
//            }
//            executors.shutdown();
//        System.out.println("Runnable Finished");

        //Callable Example

//        System.out.println("Callable Started");
//
//        Callable<Long> callable1 = new CallableDemo("A");
//        Callable<Long> callable2 = new CallableDemo("B");
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<Long> res1 = executorService.submit(callable1);
//        Future<Long> res2 = executorService.submit(callable2);
//
//        executorService.shutdown();
//
//        System.out.println("Callable Finished");

        //Semaphore Demo
//        System.out.println("Semaphore Demo : ");
//        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
//        semaphoreDemo.demo();

        //CountDownLatch Demo
//        System.out.println("CountDownLatch Demo : ");
//        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
//        countDownLatchDemo.demo();

        //CyclicBarrier Demo
//        System.out.println("CyclicBarrier Demo : ");
//        CyclicBarrierExample cyclicBarrierExample = new CyclicBarrierExample();
//        cyclicBarrierExample.demo();

        //Exchanger Demo
//        System.out.println("Exchanger Demo : ");
//        ExchangerExample exchangerExample = new ExchangerExample();
//        exchangerExample.demo();

        //Phaser Demo
//        System.out.println("Phaser Demo : ");
//        PhaserExample phaserExample = new PhaserExample();
//        phaserExample.demo();

    }
}