package org.hilmi.packett.exception;

import java.io.IOException;

/**
 * Exception thrown when there is an exception while transforming a WebSocketMessage request into a response
 */
public class RequestTransformException extends IOException
{
    public RequestTransformException(String var1, Throwable var2)
    {
        super(var1, var2);
    }

    public RequestTransformException(String var1)
    {
        super(var1);
    }
}
