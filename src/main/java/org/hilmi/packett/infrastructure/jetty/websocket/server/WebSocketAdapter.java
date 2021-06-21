package org.hilmi.packett.infrastructure.jetty.websocket.server;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketAdapter implements WebSocketListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketAdapter.class);
    private volatile Session session;
    private RemoteEndpoint remote;

    public WebSocketAdapter(){
    }

    public WebSocketAdapter(Session session) {
        this.session = session;
        this.remote = session.getRemote();
    }

    public RemoteEndpoint getRemote()
    {
        return remote;
    }

    public Session getSession()
    {
        return session;
    }


    /**
     * Sends a message through the websocket
     * @param message String of the message to be sent through the websocket
     * @throws IOException when we can't send the message
     */
    public void sendMessage(String message) throws IOException
    {
        assert session != null;
        session.getRemote()
                .sendString(message);
    }

    /**
     * Sends a message through the websocket
     * @param message Bytebuffer of the message to be sent through the websocket
     * @throws IOException when we can't send the message
     */
    public void sendMessage(ByteBuffer message) throws IOException
    {
        assert session != null;
        session.getRemote()
                .sendBytes(message);
    }


    @Override
    public void onWebSocketBinary(byte[] payload, int offset, int len)
    {
        /* do nothing */
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason)
    {
        this.session = null;
        this.remote = null;
    }

    @Override
    public void onWebSocketConnect(Session sess)
    {
        this.session = sess;
        this.remote = sess.getRemote();
    }

    @Override
    public void onWebSocketError(Throwable cause)
    {
        /* do nothing */
    }

    @Override
    public void onWebSocketText(String message)
    {
        /* do nothing */
        LOGGER.info("Received message: {}", message);
    }
}
