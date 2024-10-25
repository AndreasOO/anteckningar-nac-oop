package OOP.Sprint3.Uppgift10ad;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {
    private static int CONSUMER_ID_INCREMENTOR = 1;

    private final int consumerID;
    private final List<String> consumedProducts;
    private final int time;
    private final MyQueue queue;


    public Consumer(int time, MyQueue queue) {
        this.consumerID = CONSUMER_ID_INCREMENTOR++;
        this.consumedProducts = new ArrayList<>();
        this.time = time;
        this.queue = queue;

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                consumedProducts.add(queue.take());
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(String.format("Consumer with ID %d interrupted", this.consumerID));
                break;
            }
        }
    }

    public void printConsumedProducts() {
        System.out.println("Printing products for Consumer ID: " + consumerID + "\n" + consumedProducts + "\n");
    }
}
