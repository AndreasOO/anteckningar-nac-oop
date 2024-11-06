package OOP.Sprint4.Uppgift2a_c.Sender;

public class Main {
    public static void main(String[] args) {

        try {

            ReceiptReceiver receiptReceiver = new ReceiptReceiver(4443);
            Thread thread1 = new Thread(receiptReceiver);
            thread1.start();

            QuoteMachine quoteMachine = new QuoteMachine(4444);
            Thread thread2 = new Thread(quoteMachine);
            thread2.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
