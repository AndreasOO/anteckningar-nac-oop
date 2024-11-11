package OOP.Sprint4.Uppgift3.Client.StateMachine;

import OOP.Sprint4.Uppgift3.Reponses.Response;

public interface ConnectionState {
    void sendMessage();
    void toggleConnection();
    void handleResponse(Response response);
    void handleBroadcast(Response response);
    void handleUserOnlineListUpdate(Response response);
    void handleUserLogout(Response response);
}
