package OOP.Sprint4.Uppgift15a_b;

public class Main {
    public static void main(String[] args) {

        Queue<Number> queue = new Queue<>();
        queue.put(5);
        queue.put(6);
        queue.put(7);
        queue.put(8.2);

        System.out.println(queue.size());


//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());

        Queue<? extends Number> queue2 = queue.transfer();

        System.out.println();

        System.out.println(queue2.take());
        System.out.println(queue2.take());
        System.out.println(queue2.take());
        System.out.println(queue2.take());





    }

}
