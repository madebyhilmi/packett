package org.hilmi.packett.infrastructure.jetty.websocket.server;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;


public class PackettServlet extends WebSocketServlet
{
    private static final long serialVersionUID = 0L;
    private static final long ASYNC_WRITE_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(5);
    private static final long SOCKET_IDLE_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(30);

    private static final int TEN = 10;
    private static final int MAX_TEXT_MESSAGE_SIZE_BYTES = 512 * (1 << TEN); // 512 KiB

    PackettServlet()
    {
    }

    /**
     * Configures the servlet to use the websocket listener and adapters so we have control over communication
     * @param factory WebSocketServletFactory that builds the websocket
     */
    @Override
    public void configure(WebSocketServletFactory factory)
    {
        configureWebSocketPolicy(factory.getPolicy());

        factory.setCreator(new PackettWebSocketCreator());
        factory.register(WebSocketAdapter.class);
    }

    /**
     * Configures the web socket policy of the connected server
     * @param webSocketPolicy WebSocketPolicy that is used to configure the websocket
     */
    private static void configureWebSocketPolicy(final WebSocketPolicy webSocketPolicy)
    {
        webSocketPolicy.setIdleTimeout(SOCKET_IDLE_TIMEOUT_MS);
        // The Async Write Timeout must be <= to the idle timeout. We must set it after setting the idle timeout.
        // Passes setting through to the WebSocketPolicy
        // (Default 60000)
        webSocketPolicy.setAsyncWriteTimeout(Math.min(SOCKET_IDLE_TIMEOUT_MS, ASYNC_WRITE_TIMEOUT_MS));

        /* These limits apply to the parsing of incoming frames */

        // Text message max size is 64 KiB by default
        webSocketPolicy.setMaxTextMessageSize(MAX_TEXT_MESSAGE_SIZE_BYTES);
        // Binary message max size is 64 KiB by default. -1 means unlimited
    }

}
