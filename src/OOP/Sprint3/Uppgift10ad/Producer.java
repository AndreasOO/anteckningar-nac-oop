package OOP.Sprint3.Uppgift10ad;

import java.util.Timer;

public class Producer implements Runnable {
    private static int PRODUCER_ID_INCREMENTOR = 1;

    private final int producerID;
    private int productID;
    private final String productString;
    private final int time;
    private final MyQueue queue;
    private final int priority;


    public Producer(String productString, int time, MyQueue queue, int priority) {
        this.producerID = PRODUCER_ID_INCREMENTOR++;
        this.productID = 1;
        this.productString = productString;
        this.time = time;
        this.queue = queue;
        this.priority = priority;

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
           try {
               queue.put(String.format("Product: %s - Product ID: %d - Producer ID: %d", this.productString, this.productID++, this.producerID));
               Thread.sleep(time);
           } catch (InterruptedException e) {
               System.out.println(String.format("Producer with ID %d interrupted", this.producerID));
           }
        }
    }

    public int getPriority() {
        return priority;
    }
}
