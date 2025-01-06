package producerConsumerQueueProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumer {
    Queue<Integer> queue = new LinkedList<>();
    int size;

    public  ProducerAndConsumer(int size){
        this.size = size;
    }

    public synchronized void produce(int data) throws InterruptedException {
        System.out.println("Producer is trying to add : "+data);
        while (this.queue.size()==size){
            System.out.println("Producer is waiting as queue is full.");
            wait(); // Producer will wait and release monitor lock
        }
        // If monitor lock is there it will acquire monitor lock
        this.queue.offer(data);
        System.out.println(data+" is added in the queue");
        notify(); // Will release the monitor lock and notify all the threads
    }

    public synchronized int consumer() throws InterruptedException {
        while (this.queue.isEmpty()){
            wait(); // Consumer will wait and release monitor lock
        }
        // If monitor lock is there it will acquire monitor lock
        int data = this.queue.poll();
        notify();
        System.out.println("Consumer picked data : "+data);
        return data;
    }
}
