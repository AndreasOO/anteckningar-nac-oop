package OOP.Sprint4.Uppgift2a_c.Sender;

import java.io.IOException;
import java.net.*;

public class ReceiptReceiver implements Runnable {
    InetAddress ip;
    int port;
    DatagramSocket socket;
    DatagramPacket packet;

    public ReceiptReceiver(int port) throws UnknownHostException, SocketException {
        this.ip = InetAddress.getLocalHost();
        this.port = port;
        this.socket = new DatagramSocket(this.port, this.ip);
        this.packet = new DatagramPacket(new byte[1024], 1024);
    }

    public void startReceiving() throws IOException {
        String message = null;
        System.out.println("Starting to receive receipts");
        while (true) {
            socket.receive(packet);
            message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received receipt of received message: " + message);
        }
    }

    public void run() {
        try {
            startReceiving();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
