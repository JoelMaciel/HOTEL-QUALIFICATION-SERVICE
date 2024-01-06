package com.joelmaciel.qualificationservice.domain.exceptions;

import java.util.UUID;

public class HotelNotFoundException extends ResourceNotFoundException {
    public HotelNotFoundException(String message) {
        super(message);
    }

}
