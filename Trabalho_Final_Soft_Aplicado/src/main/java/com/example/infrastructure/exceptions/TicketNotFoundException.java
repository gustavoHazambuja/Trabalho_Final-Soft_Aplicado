package com.example.infrastructure.exceptions;

public class TicketNotFoundException extends RuntimeException {
    
    public TicketNotFoundException(String message){
        super(message);
    }
}
