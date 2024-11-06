package OOP.Sprint4.Uppgift4b.Receiver;

public class Main {
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 3; i++) {
                new Thread(new ReportReceiver(4442)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
