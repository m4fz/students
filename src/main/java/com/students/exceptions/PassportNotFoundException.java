package com.students.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PassportNotFoundException extends RuntimeException{
    public PassportNotFoundException(String message) {
        super(message);
    }
}
