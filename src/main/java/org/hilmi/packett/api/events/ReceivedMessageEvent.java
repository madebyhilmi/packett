package org.hilmi.packett.api.events;

public class ReceivedMessageEvent<T> extends Event<ReceivedMessageEvent<T>>
{

    private final T message;

    public ReceivedMessageEvent(T message)
    {
        super(Type.RECEIVED_MESSAGE);
        this.message = message;
    }

    public T getMessage()
    {
        return message;
    }

}


