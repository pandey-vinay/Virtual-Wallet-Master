package com.Wallet.Task.virtualwallet.exception;

import com.Wallet.Task.virtualwallet.models.Customer;

public class CustomerAlreadyHasWalletException extends Exception {
    public CustomerAlreadyHasWalletException(Customer customer) {
        super("Customer "+customer.getFname()+" "+customer.getLname()+" already owns a wallet : "+customer.getWallet().getWalletId());
    }
}
