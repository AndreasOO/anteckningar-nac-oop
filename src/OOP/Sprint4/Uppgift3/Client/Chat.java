package OOP.Sprint4.Uppgift3.Client;

import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Requests.RequestType;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Chat implements Runnable {
    private static int clientIDIncrementor = 1;
    private final int clientID;
    GUI gui;
    InetAddress ip;
    int port;
    String username;
    Status status;

    public Chat(int port, String username) {
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }

        this.clientID = clientIDIncrementor++;
        this.port = port;
        this.username = username;

    }

    public void run() {
        gui = new GUI(username);
        gui.init();

        startServerListenerThread();
        addEventListeners();
    }

    private void startServerListenerThread() {
        new Thread(() -> {
            try (Socket socket = new Socket(ip,port);
                 ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()));
                 ObjectInputStream in = new ObjectInputStream((socket.getInputStream()));) {

                out.writeObject(new Request(clientID, RequestType.LISTENING, username, ""));
                status = Status.CONNECTED;
                gui.getDisconnectButton().setText("Disconnect");

                Object serverResponse;
                while ((serverResponse = in.readObject()) != null) {

                    Response serverResponseCast =  serverResponse instanceof Response ? (Response) serverResponse : null;

                    switch (serverResponseCast.getResponseType()) {
                        case BROADCAST -> gui.getTextArea().append(serverResponseCast.getPayload() + "\n");
                        case LISTENING_CONNECTION_ESTABLISHED -> gui.getTextArea().append(serverResponseCast.getPayload() + "\n");
                        case LISTENING_CONNECTION_TERMINATED -> {
                            gui.getTextArea().append(serverResponseCast.getPayload() + "\n");
                            return;
                        }
                    }


                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void addEventListeners() {
        gui.getTextField().addActionListener((e) -> {
            switch (status) {
                case CONNECTED -> sendMessage(gui.getTextField().getText());
                case DISCONNECTED -> gui.getTextArea().append("Cannot send messages when disconnected\n");
            }

        });

        gui.getDisconnectButton().addActionListener((e) -> {
            if (e.getSource() == gui.getDisconnectButton()) {
                switch (status) {
                    case CONNECTED -> requestTermination();
                    case DISCONNECTED -> startServerListenerThread();
                }
            }
        });
    }

    public void sendMessage(String message) {

        try (Socket socket = new Socket(ip,port);
             ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()))) {

            out.writeObject(new Request(clientID, RequestType.MESSAGE, username, message));

        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void requestTermination() {
        try (Socket socket = new Socket(ip,port);
             ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()))) {

            out.writeObject(new Request(clientID, RequestType.TERMINATION, username, ""));
            gui.getDisconnectButton().setText("Connect");
            status = Status.DISCONNECTED;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
