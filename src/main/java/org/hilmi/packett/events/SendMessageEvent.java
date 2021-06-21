package org.hilmi.packett.events;

public class SendMessageEvent<T> extends Event<SendMessageEvent<T>> {

    private final T message;

    public SendMessageEvent(T message) {
        super(Type.SEND_MESSAGE);
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

}
