package com.Wallet.Task.virtualwallet.exception;

public class CustomerDoesNotExistException extends Exception {

    public CustomerDoesNotExistException(Integer customerId) {
        super("Customer with customer ID:" + customerId + " does not exist");
    }
}
