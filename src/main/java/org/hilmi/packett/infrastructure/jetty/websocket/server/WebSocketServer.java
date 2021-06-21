package org.hilmi.packett.infrastructure.jetty.websocket.server;


import javax.servlet.ServletException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.server.NativeWebSocketServletContainerInitializer;
import org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketServer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);
    public static final int MAX_TEXT_MESSAGE_BUFFER_SIZE = 65535;

    private final Server server;
    private int port;

    public WebSocketServer(int port)
    {
        this.port = port;

        server = new Server();
        var connector = new ServerConnector(server);
        connector.setPort(port);
        server.addConnector(connector);

        PackettServlet simulatorServlet = new PackettServlet();

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        var handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(simulatorServlet), "/*");

        try
        {
            // Configure specific websocket behavior
            NativeWebSocketServletContainerInitializer.configure(handler,
                    (servletContext, nativeWebSocketConfiguration) -> nativeWebSocketConfiguration.getPolicy()
                            .setMaxTextMessageBufferSize(MAX_TEXT_MESSAGE_BUFFER_SIZE));

            // Add generic filter that will accept WebSocket upgrade.
            WebSocketUpgradeFilter.configure(handler);
        }
        catch (ServletException ex)
        {
            LOGGER.error("Unable to configure servlet.", ex);
        }
    }

    /**
     * Starts the server to listen for connections
     *
     * @throws Exception when server cannot start
     */
    public void start() throws Exception
    {
        server.start();
        this.port = ((ServerConnector)server.getConnectors()[0]).getLocalPort();
        LOGGER.info("Server started on port {}...", port);
    }

    /**
     * Shuts the server down
     *
     * @throws Exception when the server cannot stop
     */
    public void close() throws Exception
    {
        server.stop();
    }


    /**
     * Gets the port the server is configured on. If the server is not started, it will return the passed in port. If
     * running it will return the port the server is using. This is important when dynamic ports (0) are used.
     *
     * @return int the port the server is using.
     */
    public int getPort()
    {
        return port;
    }
}
