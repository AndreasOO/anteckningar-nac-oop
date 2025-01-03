package OOP.Sprint4.Uppgift4a.Sender;

import javax.swing.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReportSender implements Runnable {
    InetAddress ip;
    int port;
    DatagramSocket socket;
    DatagramPacket packet;
    String payload;
    GUISender gui;

    public ReportSender(int port) throws Exception {
        this.ip = InetAddress.getLocalHost();
        this.port = port;
        this.socket = new DatagramSocket();
    }

    public void startProgram() {
        initGUI();
        addEventListeners();
    }

    private void initGUI() {
        String title = JOptionPane.showInputDialog("Enter city");
        if (title == null) {
            System.exit(0);
        }
        gui = new GUISender(title);
        gui.init();

    }

    private void addEventListeners()  {
        gui.getTextFieldInput().addActionListener(e -> {
            getReport();
            formatReport();
            sendReport();
            cleanGUI();
        });

        gui.getButton().addActionListener(e -> {
            if (e.getSource() == gui.getButton()) {
                getReport();
                formatReport();
                sendReport();
                cleanGUI();
            }
        });
    }

    private void cleanGUI() {
        gui.getTextFieldInput().setText("");
        JOptionPane.showMessageDialog(null, "Report sent");
    }

    private void getReport() {
        payload = gui.getTextFieldInput().getText();
    }

    private void formatReport() {
        payload = gui.getFrame().getTitle() + ", " + payload;
    }
    private void sendReport() {
        try {
            socket.send(new DatagramPacket(payload.getBytes(), payload.getBytes().length, ip, port));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        startProgram();
    }
}
