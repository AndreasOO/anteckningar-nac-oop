package OOP.Sprint4.Uppgift5a_b.Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
    InetAddress ip;
    int port;
    int initialDelay;

    public Client(int port, int initialDelay) {
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }
        this.initialDelay = initialDelay;
        this.port = port;
    }

    public void establishConnection() {
        try (Socket socketToServer = new Socket(ip, port);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()))) {
            System.out.println("Made it here");
            if (in.readLine() == null) {
                System.out.println("Connection error");
            } else {
                System.out.println(in.readLine());
            }
            String connectionResult = in.readLine();
            System.out.println(connectionResult);

            String name = JOptionPane.showInputDialog("Enter contact name");
            if (name == null) {
                return;
            }

            out.println(name);

            String result = in.readLine();

            JOptionPane.showMessageDialog(null, result);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
//        try{
//            Thread.sleep(initialDelay);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        establishConnection();
    }

}
