package org.hilmi.packett.infrastructure.jetty.websocket.server;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

public class WebSocketAdapter implements WebSocketListener
{

    private volatile Session session;
    private RemoteEndpoint remote;

    public RemoteEndpoint getRemote()
    {
        return remote;
    }

    public Session getSession()
    {
        return session;
    }

    public boolean isConnected()
    {
        Session sess = this.session;
        return (sess != null) && (sess.isOpen());
    }

    public boolean isNotConnected()
    {
        Session sess = this.session;
        return (sess == null) || (!sess.isOpen());
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
    }
}
