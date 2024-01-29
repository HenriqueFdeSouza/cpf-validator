package com.github.henriquefdesouza.cpfvalidator.exception;

public class CpfInvalidException extends RuntimeException{
    public CpfInvalidException(String message) {
        super(message);
    }
}
