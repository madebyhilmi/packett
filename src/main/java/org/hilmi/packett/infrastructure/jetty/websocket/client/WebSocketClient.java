package org.hilmi.packett.infrastructure.jetty.websocket.client;

import java.net.URI;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.hilmi.packett.infrastructure.jetty.websocket.server.WebSocketAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the websocket for a client simulator. Contains methods that allow it to start and stop the websocket
 * session
 */
public class WebSocketClient
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketClient.class);

    private final URI destURI;
    private final org.eclipse.jetty.websocket.client.WebSocketClient client;
    private WebSocketAdapter adapter;

    public WebSocketClient(URI destURI)
    {
        this.destURI = destURI;
        this.client = new org.eclipse.jetty.websocket.client.WebSocketClient();
        this.adapter = new WebSocketAdapter();
    }

    /**
     * Starts the websocket connection. Also will store the attempted connection time which is used to determine whether
     * a connection occurs within a specified time. Jetty sessions do not have a good way to track when this occurs or
     * time to connect.
     *
     * @throws Exception when the websocket client cannot start
     */
    public void start() throws Exception
    {
        client.start();

        var request = new ClientUpgradeRequest();

        var future = client.connect(adapter, destURI, request);
        var session = future.get();
        adapter = new WebSocketAdapter(session);
        LOGGER.info("Connected to: {}", destURI);
    }

    /**
     * Closes the websocket connection
     *
     * @throws Exception when the websocket cannot stop
     */
    public void close() throws Exception
    {
        client.stop();
    }

    public int getPort()
    {
        return adapter.getSession()
                .getRemoteAddress()
                .getPort();
    }

    public WebSocketAdapter getAdapter()
    {
        return adapter;
    }
}
