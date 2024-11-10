package OOP.Sprint4.Uppgift3.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(44444);
        new Thread(server).start();
    }
}
