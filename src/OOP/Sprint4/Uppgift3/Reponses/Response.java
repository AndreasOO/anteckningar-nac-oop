package OOP.Sprint4.Uppgift3.Reponses;

import java.io.Serializable;

public class Response implements Serializable {
    private ResponseType responseType;
    private String payload;

    public Response(ResponseType responseType, String payload) {
        this.responseType = responseType;
        this.payload = payload;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public String getPayload() {
        return payload;
    }
}
