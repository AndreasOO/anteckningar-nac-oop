package OOP.Sprint4.Uppgift5a_b.Client;

public class Main {
    public static void main(String[] args) {


            new Thread(new Client(44441, 1)).start();

            new Thread(new Client(44441, 20)).start();

            new Thread(new Client(44441, 30)).start();


    }
}
