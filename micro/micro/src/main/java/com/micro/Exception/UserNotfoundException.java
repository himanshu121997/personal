package com.micro.Exception;

public class UserNotfoundException extends RuntimeException {
    public UserNotfoundException() {
        super();
    }

    public UserNotfoundException(String message) {
        super(message);
    }
}
