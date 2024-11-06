package OOP.Sprint4.Uppgift4b.Receiver;

import javax.swing.*;
import java.net.*;

public class ReportReceiver implements Runnable{
    InetAddress ip;
    InetSocketAddress address;
    int port;
    MulticastSocket socket;
    DatagramPacket packet;
    String report;
    GUIReceiver gui;
    NetworkInterface networkInterface;

    public ReportReceiver(int port) throws Exception {
        this.port = port;
        ip = InetAddress.getByName("234.234.234.234");
        address = new InetSocketAddress(ip, port);
        packet = new DatagramPacket(new byte[1024], 1024);
        socket = new MulticastSocket(this.port);
        networkInterface = NetworkInterface.getByInetAddress(ip);
        socket.joinGroup(address,networkInterface);
        gui = new GUIReceiver();
    }

    public void startProgram() throws Exception {
        gui.init();
        startReceive();
    }

    public void startReceive() throws Exception {
        while (true) {
            socket.receive(packet);
            report = new String(packet.getData(), 0, packet.getLength());
            gui.getPanel().add(new JLabel(report));
            gui.getFrame().repaint();
            gui.getFrame().revalidate();
        }
    }

    public void run() {
        try {
            startProgram();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
