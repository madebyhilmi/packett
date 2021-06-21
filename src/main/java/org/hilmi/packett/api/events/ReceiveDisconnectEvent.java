package org.hilmi.packett.api.events;

public class ReceiveDisconnectEvent extends Event<ReceiveDisconnectEvent>
{

    public ReceiveDisconnectEvent()
    {
        super(Type.RECEIVE_DISCONNECT);
    }

}
