package OOP.Sprint4.Uppgift3.Server.StateMachine;

import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Server.ClientConnection;

import java.io.IOException;

public class MessageRequestHandlingState implements RequestHandlingState {
    ClientConnection connection;
    public MessageRequestHandlingState(ClientConnection connection) {
        this.connection = connection;
    }

    public void handleRequest(Request request) throws IOException {
        String message = request.getUsername() + ": " +request.getPayload();
        connection.database.addMessage(message);
        connection.server.broadcast(message);
        connection.out.close();
        connection.in.close();
    }
}
