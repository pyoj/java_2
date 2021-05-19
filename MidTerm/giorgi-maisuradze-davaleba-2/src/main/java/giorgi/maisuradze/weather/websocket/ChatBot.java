package giorgi.maisuradze.weather.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint("/weather")
public class ChatBot {

    @OnOpen
    public void open() {
        System.out.println("Connetion open");
    }

    @OnMessage
    public String message(String msg) {

        return WeatherAPIService.processCommand(msg);
    }

    @OnClose
    public void close() {
        System.out.println("Close");
    }

    @OnError
    public void error(Throwable t) {
        System.out.println("Error " + t);
    }
}
