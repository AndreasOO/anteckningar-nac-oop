package OOP.Sprint4.Uppgift3.Client.StateMachine;

import OOP.Sprint4.Uppgift3.Client.Chat;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Requests.RequestType;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectedToServerState implements ConnectionState {
    Chat chat;

    public ConnectedToServerState(Chat chat) {
        this.chat = chat;
    }


    @Override
    public void sendMessage() {
        String message = chat.gui.getTextField().getText();
        try (Socket socket = new Socket(chat.ip,chat.port);
             ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()))) {

            out.writeObject(new Request(chat.clientID, RequestType.MESSAGE, chat.username, message));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void toggleConnection() {
        try (Socket socket = new Socket(chat.ip,chat.port);
             ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()))) {

            out.writeObject(new Request(chat.clientID, RequestType.TERMINATION, chat.username, ""));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
