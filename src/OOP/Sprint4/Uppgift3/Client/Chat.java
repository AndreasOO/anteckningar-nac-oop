package OOP.Sprint4.Uppgift3.Client;

import OOP.Sprint4.Uppgift3.Client.StateMachine.ConnectedToServerState;
import OOP.Sprint4.Uppgift3.Client.StateMachine.ConnectionState;
import OOP.Sprint4.Uppgift3.Client.StateMachine.DisconnectedFromServer;
import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Requests.RequestType;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Chat implements Runnable {
    private static int clientIDIncrementor = 1;
    public final int clientID;
    public GUI gui;
    public InetAddress ip;
    public int port;
    public String username;
    public ConnectionState state;
    public ConnectionState connectedToServerState;
    public ConnectionState disconnectedFromServerState;

    public Chat(int port, String username) {
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            ip = InetAddress.getLoopbackAddress();
        }

        this.clientID = clientIDIncrementor++;
        this.port = port;
        this.username = username;

        connectedToServerState = new ConnectedToServerState(this);
        disconnectedFromServerState = new DisconnectedFromServer(this);

    }

    public void run() {
        gui = new GUI(username);
        gui.init();

        startServerListenerThread();
        addEventListeners();
    }

    public void startServerListenerThread() {
        new Thread(() -> {
            try (Socket socket = new Socket(ip,port);
                 ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()));
                 ObjectInputStream in = new ObjectInputStream((socket.getInputStream()));) {

                out.writeObject(new Request(clientID, RequestType.LISTENING, username, ""));

                while ((in.readObject()) instanceof Response response) {
                    switch (response.getResponseType()) {

                        case LISTENING_CONNECTION_ESTABLISHED -> {
                            state = connectedToServerState;
                            state.handleResponse(response);
                        }

                        case BROADCAST -> state.handleBroadcast(response);

                        case LISTENING_CONNECTION_TERMINATED -> {
                            state = disconnectedFromServerState;
                            state.handleResponse(response);
                            return;}
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
            state.sendMessage();
        });

        gui.getDisconnectButton().addActionListener((e) -> {
            if (e.getSource() == gui.getDisconnectButton()) {
                state.toggleConnection();
            }
        });
    }
}
