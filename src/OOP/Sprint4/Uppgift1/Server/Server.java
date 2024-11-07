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
    ServerSocket socket2;


    public Server(int port) {
        this.port = port;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }
    }

    public void startServer() {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Server started");
                while (true) {
                    try (Socket socketToClient = serverSocket.accept();
                         BufferedReader reader = new BufferedReader(new InputStreamReader(socketToClient.getInputStream()))) {

                        System.out.println("Established connection with client: " + socketToClient.getInetAddress());
                        String inputLine;
                        if ((inputLine = reader.readLine()) != null) {
                            System.out.println("Server received message: " + inputLine + " - from ip: " + socketToClient.getInetAddress());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    public void run() {
        startServer();
    }
}
