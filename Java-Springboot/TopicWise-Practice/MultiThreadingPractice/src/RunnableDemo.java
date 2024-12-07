
public class RunnableDemo implements Runnable{

    String runnableDemoIdentification;

    public  RunnableDemo (String runnableDemoIdentification){
        this.runnableDemoIdentification = runnableDemoIdentification;
    }

    @Override
    public void run() {
            for (int i=0; i<5; i++){
                System.out.println("Executing in Runnable | runnableDemoIdentification : "+this.runnableDemoIdentification);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}
