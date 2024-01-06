package com.joelmaciel.qualificationservice.domain.exceptions;

public abstract class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
