package com.btaj.app.rest.exception;

public class HeadquarterNotFoundException extends Exception {
    private static final long serialVersionUID = -3143078852573188050L;

    public HeadquarterNotFoundException() {
    }

    public HeadquarterNotFoundException(String message) {
        super("Headquarter not found "+message);
    }

    public HeadquarterNotFoundException(Throwable cause) {
        super(cause);
    }

    public HeadquarterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HeadquarterNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
