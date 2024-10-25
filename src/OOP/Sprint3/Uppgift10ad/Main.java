package OOP.Sprint3.Uppgift10ad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        MyQueue myQueue = new MyQueue();

        Thread producer1 = new Thread(new Producer("Apple", 100, myQueue));

        List<Thread> threads = new ArrayList<>();
        Consumer consumer1 = new Consumer(1000, myQueue);
        Consumer consumer2 = new Consumer(1500, myQueue);
        Consumer consumer3 = new Consumer(1800, myQueue);

        threads.add(producer1);
        threads.add(new Thread(consumer1));
        threads.add(new Thread(consumer2));
        threads.add(new Thread(consumer3));

        threads.forEach(Thread::start);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Got here3");


        threads.forEach(Thread::interrupt);

        consumer1.printConsumedProducts();
        consumer2.printConsumedProducts();
        consumer3.printConsumedProducts();


    }
}
