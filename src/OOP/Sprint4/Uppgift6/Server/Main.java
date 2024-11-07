package OOP.Sprint4.Uppgift6.Server;

public class Main {
    public static void main(String[] args) {
        new Thread(new Server(44441)).start();


    }
}
