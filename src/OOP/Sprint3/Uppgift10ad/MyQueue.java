package OOP.Sprint3.Uppgift10ad;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    List<String> queue;


    public MyQueue() {
        queue = new ArrayList<>();
    }

    synchronized void put(String o) {
        queue.add(o);
        notify();
    }

    synchronized String take() {
        if (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return queue.removeFirst();
    }
}
