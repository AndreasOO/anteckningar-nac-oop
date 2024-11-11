package OOP.Sprint4.Uppgift15a_b;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        queue.put(5);
        queue.put(6);
        queue.put(7);

        System.out.println(queue.size());


//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());

        Queue<Integer> queue2 = queue.reverse();

        System.out.println();

        System.out.println(queue2.take());
        System.out.println(queue2.take());
        System.out.println(queue2.take());
        System.out.println(queue2.take());





    }

}
