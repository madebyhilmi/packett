package org.hilmi.packett.exception;

/**
 * Exception thrown when there is an exception while validating WebSocketMessage request
 */
public class RequestValidationException extends Exception
{
    public RequestValidationException(String message)
    {
        super(message);
    }

    public RequestValidationException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
