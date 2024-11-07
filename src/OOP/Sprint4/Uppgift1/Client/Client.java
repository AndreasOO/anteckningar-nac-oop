package OOP.Sprint4.Uppgift1.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
    InetAddress ip;
    int port;
    String clientName;
    int initialDelay;

    public Client(String clientName, int port, int initialDelay) {
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }
        this.clientName = clientName;
        this.port = port;
        this.initialDelay = initialDelay;
    }

    public void connectToServer() {
        while (true) {
            try (Socket socket = new Socket(ip, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println(clientName + " sending message");
                out.println("Client: " + clientName + " testing");

                String response = null;
                if ((response = in.readLine()) != null) {
                    System.out.println(clientName + "received response: " + response);
                }
                Thread.sleep(3000);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void run() {
        try {
            Thread.sleep(initialDelay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectToServer();
    }
}
