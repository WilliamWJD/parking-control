package com.api.parkingcontrol.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String msg){
        super(msg);
    }
}
