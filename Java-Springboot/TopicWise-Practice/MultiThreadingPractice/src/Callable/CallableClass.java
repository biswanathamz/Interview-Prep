package Callable;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<Long> {
    int taskId;

    public CallableClass(int taskId){
        this.taskId = taskId;
    }
    @Override
    public Long call() throws Exception {
        System.out.println("Callable Called | Thread :"+Thread.currentThread().getName());
        System.out.println("Thread : "+Thread.currentThread().getName()+" processing task :"+this.taskId);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread : "+Thread.currentThread().getName()+" completed task :"+this.taskId);
        return null;
    }
}
