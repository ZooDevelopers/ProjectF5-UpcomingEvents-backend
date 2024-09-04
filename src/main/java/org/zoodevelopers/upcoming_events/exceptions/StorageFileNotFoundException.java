package org.zoodevelopers.upcoming_events.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Storage File not found...")

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }
    public StorageFileNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }
    
}
