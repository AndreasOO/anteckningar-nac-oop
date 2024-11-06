package OOP.Sprint4.Uppgift4a.Receiver;

import javax.swing.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReportReceiver {
    InetAddress ip;
    int port;
    DatagramSocket socket;
    DatagramPacket packet;
    String report;
    GUIReceiver gui;

    public ReportReceiver(int port) throws Exception {
        this.port = port;
        ip = InetAddress.getLocalHost();
        packet = new DatagramPacket(new byte[1024], 1024);
        socket = new DatagramSocket(this.port);
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
}
