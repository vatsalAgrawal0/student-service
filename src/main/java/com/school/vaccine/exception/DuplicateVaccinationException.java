package com.school.vaccine.exception;

public class DuplicateVaccinationException extends RuntimeException {
    public DuplicateVaccinationException(String message) {
        super(message);
    }
}
