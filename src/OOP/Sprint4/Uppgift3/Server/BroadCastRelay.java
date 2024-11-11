package OOP.Sprint4.Uppgift3.Server;

import java.io.IOException;

public interface BroadCastRelay {
    void sendMessage(String message) throws IOException;
    void updateOnlineUsersList(String user) throws IOException;

}
