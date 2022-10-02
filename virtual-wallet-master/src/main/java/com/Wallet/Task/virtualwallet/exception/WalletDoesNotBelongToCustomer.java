package com.Wallet.Task.virtualwallet.exception;


import com.Wallet.Task.virtualwallet.models.Customer;
import com.Wallet.Task.virtualwallet.models.Wallet;

public class WalletDoesNotBelongToCustomer extends Exception {
    public WalletDoesNotBelongToCustomer(Customer customer, Wallet wallet) {
        super("Customer with id"+customer.getUserId()+" does not have associated walletId : "+wallet.getWalletId());
    }
}
