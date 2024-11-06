package OOP.Sprint4.Uppgift2a_c.Sender;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteMachine implements Runnable {
    InetAddress ip;
    int port;
    DatagramPacket packet;
    DatagramSocket socket;
    int intervalInMilliseconds;
    List<String> quotes;

    public QuoteMachine(int port) throws UnknownHostException, SocketException {
        this.ip = InetAddress.getLocalHost();
        this.port = port;
        this.socket = new DatagramSocket();
        this.intervalInMilliseconds = 1000;
        this.quotes = new ArrayList<>();
        quotes.add("To be or not to be");
        quotes.add("Leeroy Jenkins");
        quotes.add("Whats that smell?");
        quotes.add("Ehhhh...");
    }

    public void startSending() throws IOException, InterruptedException {
        while (true) {
            byte[] payload = getRandomQuote().getBytes();
            packet = new DatagramPacket(payload, payload.length, ip, port);
            socket.send(packet);
            Thread.sleep(intervalInMilliseconds);
        }
    }

    public String getRandomQuote() {
        int index = new Random().nextInt(quotes.size());
        return quotes.get(index);
    }

    public void run() {
        try {
            startSending();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
