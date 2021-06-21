package org.hilmi.packett.api;

import java.util.ArrayDeque;
import java.util.Deque;

import org.hilmi.packett.api.events.CloseConnectionEvent;
import org.hilmi.packett.api.events.EstablishConnectionEvent;
import org.hilmi.packett.api.events.Event;
import org.hilmi.packett.api.events.ReceiveDisconnectEvent;
import org.hilmi.packett.api.events.ReceiveMessageEvent;
import org.hilmi.packett.api.events.ReceivePersistentMessageEvent;
import org.hilmi.packett.api.events.SendMessageEvent;
import org.hilmi.packett.api.validation.Validator;

public class Expectations
{

    private final Deque<Event> events = new ArrayDeque<>();

    public <T> Expectations sendMessage(T message)
    {
        events.add(new SendMessageEvent<>(message));
        return this;
    }

    public Expectations receiveMessage(Validator validator)
    {

        events.add(new ReceiveMessageEvent(validator));
        return this;
    }

    public Expectations receivePersistentMessage(Validator validator)
    {
        events.add(new ReceivePersistentMessageEvent(validator));
        return this;
    }

    public Expectations establishConnection(Connection connection)
    {
        events.add(new EstablishConnectionEvent(connection));
        return this;
    }

    public Expectations closeConnection()
    {
        events.add(new CloseConnectionEvent());
        return this;
    }

    public Expectations receiveDisconnect()
    {
        events.add(new ReceiveDisconnectEvent());
        return this;
    }

}
