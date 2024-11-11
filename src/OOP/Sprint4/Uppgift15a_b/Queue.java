package OOP.Sprint4.Uppgift15a_b;

import java.util.ArrayList;
import java.util.List;

public class Queue <T extends Number> {
    List<T> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public void put(Number number)  {
        list.addFirst((T) number);
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

    static public Queue<? extends Number> reverse(Queue<? extends Number> queue) {
        Queue<?> newQueue = new Queue<>();
        while (!queue.isEmpty()) {
            newQueue.put(queue.take());
        }
        return newQueue;
    }
}
