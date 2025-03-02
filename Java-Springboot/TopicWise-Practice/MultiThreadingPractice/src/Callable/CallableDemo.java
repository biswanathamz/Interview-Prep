package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public void demo() throws InterruptedException {
        Callable<Long> callableClass1 = new CallableClass(1);
        Callable<Long> callableClass2 = new CallableClass(2);

        FutureTask<Long> callableTask1 = new FutureTask<>(callableClass1);
        FutureTask<Long> callableTask2 = new FutureTask<>(callableClass2);

        Thread thread1 = new Thread(callableTask1);
        Thread thread2 = new Thread(callableTask2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
