package OOP.Sprint4.Uppgift3.Server;

import java.io.IOException;

public interface BroadCastRelay {
    public void sendMessage(String message) throws IOException;
}
