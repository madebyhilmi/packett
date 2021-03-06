package org.hilmi.packett.api.events;


import org.hilmi.packett.api.validation.Validator;

public class ReceiveMessageEvent extends Event<ReceiveMessageEvent> {
    private final Validator validator;

    public ReceiveMessageEvent(Validator validator) {
        super(Type.RECEIVE_MESSAGE);
        this.validator = validator;
    }

    public Validator getValidator() {
        return validator;
    }

}
