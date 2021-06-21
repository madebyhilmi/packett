package org.hilmi.packett.main;

import org.hilmi.packett.infrastructure.jetty.websocket.server.WebSocketServer;

public class Packett
{
    public static void main(String[] args) throws Exception
    {
        var server = new WebSocketServer(8081);
        server.start();

    }
}
