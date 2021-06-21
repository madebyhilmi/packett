package org.hilmi.packett.api.validation;

import org.hilmi.packett.api.dao.Message;
import org.hilmi.packett.api.exception.RequestValidationException;

/**
 * Functional interface for validating WebSocketMessage
 */
@FunctionalInterface
public interface Validator
{
    boolean validate(Message request) throws RequestValidationException;
}
