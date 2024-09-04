package org.zoodevelopers.upcoming_events.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "FireBase configuration dont found...")
public class IOException extends FireBaseNotFoundException {

  
    public IOException(String message) {
        super(message);
    }
    public IOException (String message, Throwable cause) {
        super(message, cause);
    }
    
}
