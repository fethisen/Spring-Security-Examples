package com.fethi.springbootsecurityjwt.service.exception;

public class UsernameAlreadyUsedException extends RuntimeException{
    public UsernameAlreadyUsedException() {
        super("Login name already used!");
    }
}
