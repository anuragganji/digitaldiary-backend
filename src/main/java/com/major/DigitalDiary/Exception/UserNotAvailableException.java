package com.major.DigitalDiary.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotAvailableException extends ResponseStatusException {
    public UserNotAvailableException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
