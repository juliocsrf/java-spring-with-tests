package io.github.juliocsrf.restapiwithtests.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {
    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
