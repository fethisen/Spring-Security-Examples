package com.fethi.springbootsecurityjwt.service.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
        super("Incorrect password");
    }
}
