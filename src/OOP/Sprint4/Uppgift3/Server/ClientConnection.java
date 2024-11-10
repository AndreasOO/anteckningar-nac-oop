package OOP.Sprint4.Uppgift3.Server;

import OOP.Sprint4.Uppgift3.Reponses.Response;
import OOP.Sprint4.Uppgift3.Reponses.ResponseType;
import OOP.Sprint4.Uppgift3.Requests.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection implements Runnable {
    Socket socket;
    Database database;
    Server server;
    ObjectOutputStream out;
    ObjectInputStream in;
    int clientID;

    public ClientConnection(Socket socket, Database database, Server server) {
        this.socket = socket;
        this.database = database;
        this.server = server;
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
                    case LISTENING -> handleListeningRequest(request);
                    case MESSAGE -> handleMessageRequest(request);
                    case TERMINATION -> handleTerminationRequest(request);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleListeningRequest(Request request) throws IOException {
        this.clientID = request.getClientID();
        server.clients.add(this);
        out.writeObject(new Response(ResponseType.LISTENING_CONNECTION_ESTABLISHED, "Welcome to the chat " + request.getUsername()));
        server.broadcast(request.getUsername() + " has joined the chat :)");
    }

    private void handleMessageRequest(Request request) throws IOException {
        String message = request.getUsername() + ": " +request.getPayload();
        database.addMessage(message);
        server.broadcast(message);
        out.close();
        in.close();
    }

    private void handleTerminationRequest(Request request) throws IOException {

        ClientConnection clientConnectionToTerminate = server.clients.stream().filter(client -> client.getClientID() == request.getClientID()).findFirst().get();
        clientConnectionToTerminate.out.writeObject(new Response(ResponseType.LISTENING_CONNECTION_TERMINATED,"Terminating connection" ));
        clientConnectionToTerminate.out.close();
        clientConnectionToTerminate.in.close();
        server.clients.remove(clientConnectionToTerminate);
        server.broadcast(request.getUsername() + " has left the chat :(");
        out.close();
        in.close();
    }

    public void sendMessage(String message) throws IOException {
        out.writeObject(new Response(ResponseType.BROADCAST, message));
    }

    public int getClientID() {
        return clientID;
    }
}
