package com.example.retrospect.user.exceptions;

public class UnauthorizedAccessException extends Exception{

    public UnauthorizedAccessException() {
        super("Unauthorized Access!");
    }

    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
