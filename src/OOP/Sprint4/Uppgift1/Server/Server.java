package OOP.Sprint4.Uppgift1.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable {
    InetAddress ip;
    int port;
    ServerSocket serverSocket;
    Socket clientSocket;


    public Server(int port) {
        this.port = port;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }
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
            System.out.println("Established connection with client: " + clientSocket.getInetAddress());
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                        String inputLine;
                        if ((inputLine = reader.readLine()) != null) {
                            System.out.println("Server received message: " + inputLine + " - from ip: " + clientSocket.getInetAddress());
                        }

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
