package com.gl.transactioncalculator.exception;

public class GeneralRuntimeException extends RuntimeException {

    public GeneralRuntimeException(String message) {
        super(message);
    }

    public GeneralRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
