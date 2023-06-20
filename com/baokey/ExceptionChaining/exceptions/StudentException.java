package com.baokey.ExceptionChaining.exceptions;

public class StudentException extends Exception{

    public StudentException() {
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
