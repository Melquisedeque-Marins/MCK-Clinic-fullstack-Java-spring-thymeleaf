package com.melck.mckthymeleaf.services.exceptions;

public class InvalidDateException extends RuntimeException{

    public InvalidDateException(String arg0) {
        super(arg0);
    }

    public InvalidDateException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }


}
