package Runnable;

public class RunnableClass implements Runnable{
    int taskId;
    public RunnableClass(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run() {
        System.out.println("RunnableDemo Called | Thread :"+Thread.currentThread().getName());
        System.out.println("Thread : "+Thread.currentThread().getName()+" processing task :"+this.taskId);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread : "+Thread.currentThread().getName()+" completed task :"+this.taskId);
    }
}
