import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Long> {

    String runnableDemoIdentification;

    public  CallableDemo (String runnableDemoIdentification){
        this.runnableDemoIdentification = runnableDemoIdentification;
    }

    @Override
    public Long call() throws Exception {
        for (int i=0; i<5; i++){
            System.out.println("Executing in Callable | callableDemoIdentification : "+this.runnableDemoIdentification);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
