package OOP.Sprint4.Uppgift2a_c.Reciever;

public class Main {
    public static void main(String[] args) {
        try {
            QuoteReciever quoteReciever = new QuoteReciever(4444);
            quoteReciever.startReceiving();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
