package OOP.Sprint4.Uppgift3.Server;

import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Reponses.ResponseType;
import OOP.Sprint4.Uppgift3.Requests.Request;
import OOP.Sprint4.Uppgift3.Server.StateMachine.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection implements Runnable, BroadCastRelay {
    public Socket socket;
    public Database database;
    public Server server;
    public ObjectOutputStream out;
    public ObjectInputStream in;
    public int clientID;
    RequestHandlingState state;
    RequestHandlingState listeningRequestState;
    RequestHandlingState messageRequestState;
    RequestHandlingState terminationRequestState;


    public ClientConnection(Socket socket, Database database, Server server) {
        this.socket = socket;
        this.database = database;
        this.server = server;
        listeningRequestState = new ListeningRequestHandlingState(this);
        messageRequestState = new MessageRequestHandlingState(this);
        terminationRequestState = new TerminationRequestHandlingState(this);
    }

    @Override
    public void run() {
        initializeClientConnection();
    }

    public void initializeClientConnection() {

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            if (in.readObject() instanceof Request request) {

                switch (request.getRequestType()) {
                    case LISTENING -> {
                        state = listeningRequestState;
                        state.handleRequest(request);
                    }
                    case MESSAGE -> {
                        state = messageRequestState;
                        state.handleRequest(request);
                    }
                    case TERMINATION -> {
                        state = terminationRequestState;
                        state.handleRequest(request);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void sendMessage(String message) throws IOException {
        out.writeObject(new Response(ResponseType.BROADCAST, message));
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
