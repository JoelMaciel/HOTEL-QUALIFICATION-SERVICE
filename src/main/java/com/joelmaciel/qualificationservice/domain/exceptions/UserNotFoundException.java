package com.joelmaciel.qualificationservice.domain.exceptions;

public class UserNotFoundException extends ResourceNotFoundException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
