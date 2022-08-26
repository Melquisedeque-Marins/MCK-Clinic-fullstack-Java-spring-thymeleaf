package com.melck.mckthymeleaf.services.exceptions;

public class ObjectIsAlreadyInUseException extends RuntimeException{
    public ObjectIsAlreadyInUseException(String message) {
        super(message);
    }
}
