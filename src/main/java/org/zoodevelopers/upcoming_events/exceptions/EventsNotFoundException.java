package org.zoodevelopers.upcoming_events.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Event dont found...")
public class EventsNotFoundException extends ServiceRunTimeException {

    public EventsNotFoundException(String message) {
        super(message);
    }
    public EventsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
