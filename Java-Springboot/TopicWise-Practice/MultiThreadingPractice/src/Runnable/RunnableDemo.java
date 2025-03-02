package Runnable;

public class RunnableDemo {
    public void demo() throws InterruptedException {
        RunnableClass runnableClass = new RunnableClass(1);
        Thread thread1 = new Thread(runnableClass);
        Thread thread2 = new Thread(new RunnableClass(2));
        Thread thread3 = new Thread(new RunnableClass(3));

        // Implementing Runnable Interface using lambda as Runnable is a Functional Interface
        Thread thread4 =new Thread(()->{
            System.out.println("Runnable.RunnableDemo Called | Thread :"+Thread.currentThread().getName());
            System.out.println("Thread : "+Thread.currentThread().getName()+" processing task :"+4);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread : "+Thread.currentThread().getName()+" completed task :"+4);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
