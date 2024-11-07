package OOP.Sprint4.Uppgift4b.Receiver;

import javax.swing.*;
import java.net.*;
import java.util.Enumeration;

public class ReportReceiver implements Runnable{
    private final InetAddress ip;
    private final InetSocketAddress address;
    private final int port;
    private final MulticastSocket socket;
    private final DatagramPacket packet;
    private final StringBuilder report;
    private final GUIReceiver gui;
    private final NetworkInterface networkInterface;

    public ReportReceiver(int port) throws Exception {
        this.port = port;
        ip = InetAddress.getByName("234.234.234.234");
        address = new InetSocketAddress(ip, port);
        packet = new DatagramPacket(new byte[1024], 1024);
        socket = new MulticastSocket(this.port);
        networkInterface = NetworkInterface.getByName("wlp0s20f3");
        System.out.println(networkInterface.getName());
        socket.joinGroup(address,networkInterface);
        System.out.println(socket.getNetworkInterface().getName());
        report = new StringBuilder();
        gui = new GUIReceiver();
    }

    public void startProgram() throws Exception {
        gui.init();
        startReceive();
    }


    public void startReceive() throws Exception {
        while (true) {
            socket.receive(packet);
            report.append(new String(packet.getData(), 0, packet.getLength()));
            gui.getPanel().add(new JLabel(report.toString()));
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
