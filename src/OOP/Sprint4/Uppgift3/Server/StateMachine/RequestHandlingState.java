package OOP.Sprint4.Uppgift3.Server.StateMachine;

import OOP.Sprint4.Uppgift3.Requests.Request;

import java.io.IOException;

public interface RequestHandlingState {
    void handleRequest(Request request) throws IOException;
}
