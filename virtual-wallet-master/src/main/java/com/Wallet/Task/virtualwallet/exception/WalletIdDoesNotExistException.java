package com.Wallet.Task.virtualwallet.exception;

public class WalletIdDoesNotExistException extends  Exception {
    public WalletIdDoesNotExistException(int walletId) {
        super("Wallet with walletId : "+walletId+" does not exist");
    }
}
