package OOP.Sprint4.Uppgift3.Client.StateMachine;

import OOP.Sprint4.Uppgift3.Client.Chat;

public class DisconnectedFromServer implements ConnectionState {
    Chat chat;

    public DisconnectedFromServer(Chat chat) {
        this.chat = chat;
    }


    @Override
    public void sendMessage() {
        chat.gui.getTextArea().append("Cannot send messages when disconnected\n");
        chat.gui.getTextField().setText("");
        chat.gui.getTextField().requestFocus();
    }

    @Override
    public void toggleConnection() {
        chat.startServerListenerThread();

    }
}