package org.hilmi.packett.infrastructure.jetty.websocket.server;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

public class PackettWebSocketCreator implements WebSocketCreator
{

    PackettWebSocketCreator()
    {
    }

    /**
     * Decides what to do when we create a websocket session when a client connects to the ServerSimulator
     * @param req Request for the servlet to be upgraded to a websocket
     * @param resp Response to the client that the servlet has been upgraded to a websocket
     * @return A SimulatorWebSocketAdapter that is connected to a ServerSimulator
     */
    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp)
    {
        return null;
    }
}
