package com.example.examserver.exception;

public class UserFoundException extends RuntimeException{

    public UserFoundException(){
        super("Username already exists");
    }
    public UserFoundException(String message) {
        super(message);
    }
}
