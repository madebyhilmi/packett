package org.hilmi.packett.api.events;


import org.hilmi.packett.api.validation.Validator;

public class ReceivePersistentMessageEvent extends Event<ReceivePersistentMessageEvent> {
    private final Validator validator;

    public ReceivePersistentMessageEvent(Validator validator)
    {
        super(Type.RECEIVE_PERSISTENT_MESSAGE);
        this.validator = validator;
    }

    public Validator getValidator() {
        return validator;
    }
}
