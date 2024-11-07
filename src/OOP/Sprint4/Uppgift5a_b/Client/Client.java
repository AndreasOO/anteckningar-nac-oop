package OOP.Sprint4.Uppgift5a_b.Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

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

            System.out.println("Made it here");

            String connectionResult = in.readLine();
            System.out.println(connectionResult);

            String name = userInput.readLine();

            out.println(name);

            String result = in.readLine();

            System.out.println(result);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        establishConnection();
    }

}
