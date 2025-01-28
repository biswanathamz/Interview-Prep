import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker implements Runnable{
    private final CyclicBarrier cyclicBarrier;
    private final String workerName;

    public Worker(CyclicBarrier cyclicBarrier, String workerName){
        this.cyclicBarrier = cyclicBarrier;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.workerName+" : is started working");
            Thread.sleep(1200);
            System.out.println(this.workerName + " has reached the barrier. Waiting for other Workers to reach");
            this.cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
public class CyclicBarrierExample {

    public void demo(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            try {
                Thread.sleep(2000);
                System.out.println("Barrier action executed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i=0; i<6;i++){
            new Thread(new Worker(cyclicBarrier,"Worker : "+i)).start();
        }

    }
}
