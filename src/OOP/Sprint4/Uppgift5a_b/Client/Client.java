package OOP.Sprint4.Uppgift5a_b.Client;

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


    public Client(int port) {
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }
        this.port = port;
    }

    public void establishConnection() {
        try (Socket socketToServer = new Socket(ip, port);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {


            System.out.println(in.readLine());

            out.println(userInput.readLine());

            System.out.println(in.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        establishConnection();
    }

}
