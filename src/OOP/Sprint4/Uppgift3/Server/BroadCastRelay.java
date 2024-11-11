package OOP.Sprint4.Uppgift3.Server;

import java.io.IOException;

public interface BroadCastRelay {
    public void sendMessage(String message) throws IOException;
    void notifyUserLogin(String user) throws IOException;
    void notifyUserLogout(String user) throws IOException;
}
