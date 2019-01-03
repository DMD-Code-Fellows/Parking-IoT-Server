package com.dmd.parking_iot;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/space-map/websocket")
public class WebSocketServer {

    private Session session;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
        System.out.println("on open");
        session.getBasicRemote().sendText("Connected!");
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("on message: " + message);
    }

    @OnError
    public void onError() {
        System.out.println("something broke here");
    }
}
