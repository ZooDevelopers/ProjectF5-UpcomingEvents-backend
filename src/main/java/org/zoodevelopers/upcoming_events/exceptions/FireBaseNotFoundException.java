package org.zoodevelopers.upcoming_events.exceptions;

public class FireBaseNotFoundException extends RuntimeException {
    public FireBaseNotFoundException (String message) {
        super(message);
    }

    public FireBaseNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }
}

