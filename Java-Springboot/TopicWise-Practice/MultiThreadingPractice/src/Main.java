import Runnable.RunnableDemo;
import Callable.CallableDemo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Runnable Example
//        RunnableDemo runnableDemo = new RunnableDemo();
//        runnableDemo.demo();

        // Callable Example
        CallableDemo callableDemo = new CallableDemo();
        callableDemo.demo();

    }
}