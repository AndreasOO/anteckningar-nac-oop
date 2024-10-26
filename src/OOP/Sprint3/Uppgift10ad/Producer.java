package OOP.Sprint3.Uppgift10ad;

import java.util.Timer;

public class Producer implements Runnable {
    private static int PRODUCER_ID_INCREMENTOR = 1;
    private static int PRODUCT_ID_INCREMENTOR = 1;

    private final int producerID;
    private int productID;
    private final String productString;
    private final int time;
    private final MyQueue queue;
    private final int priority;


    public Producer(String productString, int time, MyQueue queue, int priority) {
        this.producerID = PRODUCER_ID_INCREMENTOR++;

        this.productString = productString;
        this.time = time;
        this.queue = queue;
        this.priority = priority;

    }

    @Override
    public void run() {
        System.out.println("Producer " + productString + " started");
        while (!Thread.interrupted()) {
           try {
               //increment product ID here to make use of thread priority - not in constructor
               this.productID = PRODUCT_ID_INCREMENTOR++;
               queue.put(String.format("Product: %s - Product ID: %d - Producer ID: %d - Priority: %d", this.productString, this.productID++, this.producerID, getPriority()));
               Thread.sleep(time);
           } catch (InterruptedException e) {
               System.out.println(String.format("Producer with ID %d interrupted", this.producerID));
               break;
           }
        }
    }

    public int getPriority() {
        return priority;
    }
}
