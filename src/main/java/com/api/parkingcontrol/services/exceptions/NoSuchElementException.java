package com.api.parkingcontrol.services.exceptions;

public class NoSuchElementException extends RuntimeException{

    public NoSuchElementException(String msg){
        super(msg);
    }
}
