package org.hilmi.packett.validation;

import org.hilmi.packett.dao.Message;
import org.hilmi.packett.exception.RequestValidationException;

/**
 * Functional interface for validating WebSocketMessage
 */
@FunctionalInterface
public interface Validator
{
    boolean validate(Message request) throws RequestValidationException;
}
