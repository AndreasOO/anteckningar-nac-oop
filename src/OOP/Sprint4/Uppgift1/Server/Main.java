package OOP.Sprint4.Uppgift1.Server;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new Server(44449));
        thread.start();


    }
}
