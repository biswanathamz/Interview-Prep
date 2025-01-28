import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    public void doSomething(ReentrantLock reentrantLock){
        try {
            System.out.println("Thread : "+Thread.currentThread().getName()+" wants to do some operation");
            reentrantLock.lock();
            System.out.println("Thread : "+Thread.currentThread().getName()+" doing some operation");
            Thread.sleep(1000);
            System.out.println("Thread : "+Thread.currentThread().getName()+" finished the Work!");
        }catch (Exception e){
            System.out.println("Something happen");
        }finally {
            reentrantLock.unlock();
        }
    }
}
public class ReentrantLockDemo {
    SharedResource sharedResource;
    ReentrantLock lock;
    ReentrantLockDemo(){
        this.sharedResource = new SharedResource();
        lock = new ReentrantLock();
    }
    public void demo(){
        Runnable runnableFunction = ()-> {
            this.sharedResource.doSomething(lock);
        };
        for(int i = 0; i<3; i++){
            new Thread(runnableFunction).start();
        }
    }
}
