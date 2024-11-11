package OOP.Sprint4.Uppgift3.Client.StateMachine;

import OOP.Sprint4.Uppgift3.Client.Chat;

public interface ConnectionState {
    void sendMessage();
    void toggleConnection();
}
