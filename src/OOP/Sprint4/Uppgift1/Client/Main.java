package OOP.Sprint4.Uppgift1.Client;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Client("" + i, 44449, 100+i)).start();
        }
    }
}
