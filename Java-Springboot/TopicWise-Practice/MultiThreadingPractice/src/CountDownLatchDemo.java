import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public void demo(){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task = () -> {
            try {
                System.out.println("Task Completed by : "+Thread.currentThread().getName());
                Thread.sleep(2000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : was interrupted.");
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i<3; i++){
            new Thread(task).start();
        }
        try {
            countDownLatch.await();
            System.out.println("All Task Completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
