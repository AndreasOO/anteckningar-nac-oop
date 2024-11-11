package OOP.Sprint4.Uppgift15a_b;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        queue.put(5);
        queue.put(6);
        queue.put(7);



        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());

        queue.put(5);
        queue.put(6);
        queue.put(7);

        Queue<?> queue2 = Queue.reverse(queue);



        System.out.println();

        System.out.println(queue2.take());
        System.out.println(queue2.take());
        System.out.println(queue2.take());





    }

}
