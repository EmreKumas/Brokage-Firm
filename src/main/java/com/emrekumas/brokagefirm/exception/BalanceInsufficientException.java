package com.emrekumas.brokagefirm.exception;

public class BalanceInsufficientException extends RuntimeException {
    public BalanceInsufficientException(String message) {
        super(message);
    }
}
