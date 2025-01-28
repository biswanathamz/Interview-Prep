
public class RunnableDemo implements Runnable{

    int taskId;

    public  RunnableDemo (int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Executing in Runnable | Task ID  : "+this.taskId+" | Thread Id :"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
