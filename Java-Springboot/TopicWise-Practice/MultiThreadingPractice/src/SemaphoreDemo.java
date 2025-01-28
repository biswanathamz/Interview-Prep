import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public void demo(){
        Semaphore semaphore = new Semaphore(2, true);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " : attempting to acquire a permit...");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " : acquired a permit.");

                // Simulate some work with the shared resource
                System.out.println(Thread.currentThread().getName()+" : Doing some operation");
                Thread.sleep(2000);

                System.out.println(Thread.currentThread().getName() + " : release a permit.");
                semaphore.release();

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : was interrupted.");
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i<3; i++){
            new Thread(task).start();
        }
    }
}
