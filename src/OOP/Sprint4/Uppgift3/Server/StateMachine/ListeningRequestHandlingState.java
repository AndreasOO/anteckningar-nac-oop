package OOP.Sprint4.Uppgift3.Server.StateMachine;

import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Reponses.ResponseType;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Server.ClientConnection;

import java.io.IOException;

public class ListeningRequestHandlingState implements RequestHandlingState {
    ClientConnection connection;

    public ListeningRequestHandlingState(ClientConnection connection) {
        this.connection = connection;
    }

    public void handleRequest(Request request) throws IOException {
        connection.setClientID(request.getClientID());
        connection.setUsername(request.getUsername());
        connection.server.clients.add(connection);
        connection.out.writeObject(new Response(ResponseType.LISTENING_CONNECTION_ESTABLISHED, "Welcome to the chat " + request.getUsername()));
        connection.server.broadcastMessage(request.getUsername() + " has joined the chat :)");
        connection.server.broadCastUserLogin(createUsersOnlineDTO());
    }

    private String createUsersOnlineDTO() {
        StringBuilder sb = new StringBuilder();
        for (ClientConnection client : connection.server.clients) {
            sb.append(client.getUsername());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
