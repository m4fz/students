package com.students.exceptions;

public class SchoolNotFoundException extends RuntimeException{
    public SchoolNotFoundException(String message) {
        super(message);
    }
}
