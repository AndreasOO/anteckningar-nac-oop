package OOP.Sprint4.Uppgift5a_b.Server;

public class Main {
    public static void main(String[] args) {
        new Thread(new Server(44441)).start();


    }
}
