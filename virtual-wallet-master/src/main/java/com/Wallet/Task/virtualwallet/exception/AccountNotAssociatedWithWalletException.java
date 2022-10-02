package com.Wallet.Task.virtualwallet.exception;

public class AccountNotAssociatedWithWalletException extends Exception {

    public AccountNotAssociatedWithWalletException(int walletId, int accountId) {
        super("Wallet with walledId : "+walletId+" is not associated with accountId : "+accountId);
    }
}
