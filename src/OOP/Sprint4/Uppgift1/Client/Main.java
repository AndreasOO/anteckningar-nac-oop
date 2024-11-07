package OOP.Sprint4.Uppgift1.Client;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Client("Andy", 44449, 0));
        thread.start();

        Thread thread2 = new Thread(new Client("Warhol", 44449, 300));
        thread2.start();

        Thread thread3 = new Thread(new Client("Genie", 44449, 800));
        thread3.start();
    }
}
