package org.zoodevelopers.upcoming_events.exceptions;

public class ServiceRunTimeException extends RuntimeException {
    
      public ServiceRunTimeException(String message) {
        super(message);
    }

    public ServiceRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
