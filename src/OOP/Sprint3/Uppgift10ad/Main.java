package OOP.Sprint3.Uppgift10ad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        MyQueue myQueue = new MyQueue();

        Producer producer1 = new Producer("Apple", 100, myQueue, Thread.MIN_PRIORITY);
        Producer producer2 = new Producer("Orange", 100, myQueue, Thread.NORM_PRIORITY);
        Producer producer3 = new Producer("Carrot", 100, myQueue, Thread.MAX_PRIORITY);

        List<Thread> threads = new ArrayList<>();
        Consumer consumer1 = new Consumer(1000, myQueue);
        Consumer consumer2 = new Consumer(1500, myQueue);
        Consumer consumer3 = new Consumer(1800, myQueue);

        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);
        Thread producerThread3 = new Thread(producer3);

        producerThread1.setPriority(producer1.getPriority());
        producerThread2.setPriority(producer2.getPriority());
        producerThread3.setPriority(producer3.getPriority());

        threads.add(new Thread(producer1));
        threads.add(new Thread(producer2));
        threads.add(new Thread(producer3));
        threads.add(new Thread(consumer1));
        threads.add(new Thread(consumer2));
        threads.add(new Thread(consumer3));

        threads.forEach(Thread::start);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        threads.forEach(Thread::interrupt);

        consumer1.printConsumedProducts();
        consumer2.printConsumedProducts();
        consumer3.printConsumedProducts();


    }
}
