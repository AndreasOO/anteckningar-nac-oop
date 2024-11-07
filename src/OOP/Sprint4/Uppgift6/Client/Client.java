package OOP.Sprint4.Uppgift6.Client;

import OOP.Sprint4.Uppgift6.Server.Contact;

import java.io.*;
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
             ObjectInputStream inObj = new ObjectInputStream(socketToServer.getInputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {


            System.out.println(in.readLine());

            out.println(userInput.readLine());

            try {
                Object object = inObj.readObject();
                if (object instanceof Contact) {
                    Contact contact = (Contact) object;
                    System.out.println(contact);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        establishConnection();
    }

}
