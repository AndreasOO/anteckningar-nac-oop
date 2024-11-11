package OOP.Sprint4.Uppgift3.Client.StateMachine;

import OOP.Sprint4.Uppgift3.Client.Chat;
import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Requests.RequestType;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ConnectedToServer implements ConnectionState {
    Chat chat;

    public ConnectedToServer(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void handleResponse(Response response) {
        chat.gui.getDisconnectButton().setText("Disconnect");
        chat.gui.getTextArea().append(response.getPayload() + "\n");
    }


    @Override
    public void sendMessage() {
        String message = chat.gui.getTextField().getText();
        try (Socket socket = new Socket(chat.ip,chat.port);
             ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()))) {

            out.writeObject(new Request(chat.clientID, RequestType.MESSAGE, chat.username, message));
            chat.gui.getTextField().setText("");
            chat.gui.getTextField().requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void toggleConnection() {
        try (Socket socket = new Socket(chat.ip,chat.port);
             ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()))) {

            out.writeObject(new Request(chat.clientID, RequestType.TERMINATION, chat.username, ""));

            chat.gui.getRightPanel().removeAll();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void handleBroadcast(Response response) {
        chat.gui.getTextArea().append(response.getPayload() + "\n");
    }

    @Override
    public void handleUserOnlineListUpdate(Response response) {

        chat.usersOnline = List.of(response.getPayload().split(" "));
        chat.updateUsersOnline();

    }

    @Override
    public void handleUserLogout(Response response) {
        chat.usersOnline = List.of(response.getPayload().split(" "));
        chat.updateUsersOnline();
    }
}
