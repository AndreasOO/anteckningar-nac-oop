package OOP.Sprint4.Uppgift3.Client;

import OOP.Sprint4.Uppgift3.Client.StateMachine.ConnectedToServer;
import OOP.Sprint4.Uppgift3.Client.StateMachine.ConnectionState;
import OOP.Sprint4.Uppgift3.Client.StateMachine.DisconnectedFromServer;
import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Requests.RequestType;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class Chat implements Runnable {
    private static int clientIDIncrementor = 1;
    public final int clientID;
    public GUI gui;
    public InetAddress ip;
    public int port;
    public String username;
    public List<String> usersOnline;
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
        this.usersOnline = new ArrayList<>();

        connectedToServerState = new ConnectedToServer(this);
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

                        case USER_LOGIN -> state.handleUserLogin(response);

                        case USER_LOGOUT -> state.handleUserLogout(response);

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

    public void updateUsersOnline() {
        gui.getRightPanel().removeAll();

        gui.getRightPanel().add(new JLabel("  Users Online   "));
        gui.getRightPanel().add(new JLabel("___________________"));

        for (String userInList : usersOnline) {
            gui.getRightPanel().add(new JLabel(userInList));
        }
        gui.getFrame().repaint();
        gui.getFrame().revalidate();
    }
}
