package com.example.bank_service_api.exception;

public class IncorrectPINNumberException extends RuntimeException {
    public IncorrectPINNumberException(String message){
        super(message);
    }
}
