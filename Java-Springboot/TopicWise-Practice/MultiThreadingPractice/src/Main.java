import producerConsumerQueueProblem.ProducerAndConsumer;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Runnable Example

//        System.out.println("Runnable Started");
            // Using Traditional Approach
//            Thread thread1 = new Thread(new RunnableDemo(1));
//            Thread thread2 = new Thread(new RunnableDemo(2));

            // Implementing Runnable Interface using lambda as Runnable is a Functional Interface
//            Thread thread3 = new Thread(()->{
//                System.out.println("Printing with another thread | Thread ID : "+Thread.currentThread().getName());
//            });
//            thread1.start();
//            thread2.start();
//            thread3.start();

//            thread1.join();
//            thread2.join();
//            thread3.join();

            // Using Executor Approach
            ExecutorService executors = Executors.newFixedThreadPool(2);
            ThreadPoolExecutor
            for (int i=0; i<10; i++){
                executors.execute(new RunnableDemo(i));
            }
            executors.shutdown();
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

        //ReentrantLock Demo
//        System.out.println("ReentrantLock Demo : ");
//        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
//        reentrantLockDemo.demo();

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


        // Producer Consumer Queue Problem
//        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer(5);

//        Thread producerThread = new Thread(()->{
//            for (int i=0; i<20; i++){
//                try {
//                    producerAndConsumer.produce(i);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });


//        Thread consumerThread = new Thread(()->{
//            while (true){
//                try {
//                    producerAndConsumer.consumer();
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });

//        producerThread.start();
//        consumerThread.start();
    }
}