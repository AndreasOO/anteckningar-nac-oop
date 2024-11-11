package OOP.Sprint4.Uppgift15a_b;

import java.util.ArrayList;
import java.util.List;

public class Queue <T extends Number> {
    List<T> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public void put(T number)  {
        list.addFirst(number);
    }
    public T take() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Queue<? extends Number> transfer() {
        Queue<T> newQueue = new Queue<>();
        while (!this.isEmpty()) {
            newQueue.put(this.take());
        }
        return newQueue;
    }
}
