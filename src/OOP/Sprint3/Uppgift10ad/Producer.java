package OOP.Sprint3.Uppgift10ad;

import java.util.Timer;

public class Producer implements Runnable {
    private static int PRODUCER_ID_INCREMENTOR = 1;

    private final int producerID;
    private int productID;
    private final String productString;
    private final int time;
    private final MyQueue queue;


    public Producer(String productString, int time, MyQueue queue) {
        this.producerID = PRODUCER_ID_INCREMENTOR++;
        this.productString = productString;
        this.time = time;
        this.queue = queue;

    }

    @Override
    public void run() {
        while (true) {
           queue.put(String.format("Product: %s - Product ID: %d - Producer ID: %d", this.productString, this.productID, this.producerID));
           try {
               wait(time);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
}
