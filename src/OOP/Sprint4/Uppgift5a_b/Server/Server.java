package OOP.Sprint4.Uppgift5a_b.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable {
    InetAddress ip;
    int port;
    Socket clientSocket;
    ServerSocket serverSocket;
    ContactDAO contactDAO;

    public Server(int port) {
        this.port = port;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }

        contactDAO = new ContactDAO();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server started");

        while (true) {

            try {
                clientSocket = serverSocket.accept();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client connected");
            new Thread(() -> {
                try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    out.println("Connection established - Please enter contact name:");

                    String name = in.readLine();

                    String result = contactDAO.findContact(name);

                    out.println(result);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    public void run() {
        startServer();
    }
}
