package OOP.Sprint4.Uppgift2a_c.Reciever;

import java.io.IOException;
import java.net.*;

public class QuoteReciever {
    InetAddress ip;
    int port;
    DatagramSocket socket;
    DatagramPacket packet;

    public QuoteReciever(int port) throws UnknownHostException, SocketException {
        this.ip = InetAddress.getLocalHost();
        this.port = port;
        this.socket = new DatagramSocket(this.port, this.ip);
        this.packet = new DatagramPacket(new byte[1024], 1024);
    }

    public void startReceiving() throws IOException {
        String message = null;

        while (true) {
            socket.receive(packet);
            message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + message);
            message = "Received message: " + message;
            new DatagramSocket().send(new DatagramPacket(message.getBytes(), message.length(), this.ip, 4443));
        }



    }
}
