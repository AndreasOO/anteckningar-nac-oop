package OOP.Sprint4.Uppgift3.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {
    public Database database;
    public int port;
    public Socket socket;
    public List<ClientConnection> clients;

    public Server(int port) {
        database = new Database();
        this.port = port;
        clients = new ArrayList<>();
    }

    public void run() {
        startServer();
    }

    public void startServer() {
        try (ServerSocket ss = new ServerSocket(port)) {
            System.out.println("Server started");
            while (true) {
                socket = ss.accept();
                new Thread(new ClientConnection(socket, database, this)).start();
            }

        } catch (IOException e) {
            System.out.println("Server stopped");
            throw new RuntimeException(e);
        }
    }

    public void broadcastMessage(String message) throws IOException {
        for (BroadCastRelay relay : clients) {
            relay.sendMessage(message);
        }
    }

    public void broadcastUpdatedOnlineUsersList() throws IOException {
        String userList = createUsersOnlineDTO();
        for (BroadCastRelay relay : clients) {
            relay.updateOnlineUsersList(userList);
        }
    }

    private String createUsersOnlineDTO() {
        StringBuilder sb = new StringBuilder();
        for (ClientConnection client : clients) {
            sb.append(client.getUsername());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
