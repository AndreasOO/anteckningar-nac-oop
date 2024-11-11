package OOP.Sprint4.Uppgift3.Server.StateMachine;

import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Reponses.ResponseType;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Server.ClientConnection;

import java.io.IOException;

public class TerminationRequestHandlingState implements RequestHandlingState {
    ClientConnection connection;

    public TerminationRequestHandlingState(ClientConnection connection) {
        this.connection = connection;
    }

    public void handleRequest(Request request) throws IOException {
        ClientConnection clientConnectionToTerminate = connection.server.clients.stream()
                                                             .filter(client -> client.getClientID() == request.getClientID())
                                                             .findFirst()
                                                             .get();

        clientConnectionToTerminate.out.writeObject(new Response(ResponseType.LISTENING_CONNECTION_TERMINATED,"Terminating connection" ));
        clientConnectionToTerminate.out.close();
        clientConnectionToTerminate.in.close();
        connection.server.clients.remove(clientConnectionToTerminate);
        connection.server.broadcast(request.getUsername() + " has left the chat :(");
        connection.out.close();
        connection.in.close();
    }
}
