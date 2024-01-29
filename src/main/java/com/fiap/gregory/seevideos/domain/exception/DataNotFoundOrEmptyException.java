package com.fiap.gregory.seevideos.domain.exception;

public class DataNotFoundOrEmptyException extends RuntimeException {
    public DataNotFoundOrEmptyException(String message) {
        super(message);
    }
}
