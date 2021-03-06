package org.hilmi.packett.api.events;

import org.hilmi.packett.api.Connection;
import org.hilmi.packett.api.dao.Message;
import org.hilmi.packett.api.validation.Validator;


public class Event<T> {

    private final Type type;
    private Connection connection;
    private Validator validator;
    private Message message;

    Event(Type type) {
        this.type = type;

    }

    public enum Type
    {
        CLOSE,
        CONNECT,
        RECEIVE_MESSAGE,
        RECEIVE_PERSISTENT_MESSAGE,
        RECEIVED_MESSAGE,
        RECEIVE_DISCONNECT,
        SEND_MESSAGE
    }

    public Type getType() {
        return type;
    }



}
