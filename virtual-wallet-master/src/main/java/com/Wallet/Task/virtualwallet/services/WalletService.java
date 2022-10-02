package com.Wallet.Task.virtualwallet.services;

import com.Wallet.Task.virtualwallet.exception.*;
import com.Wallet.Task.virtualwallet.models.Account;
import com.Wallet.Task.virtualwallet.models.BankTransaction;
import com.Wallet.Task.virtualwallet.models.Wallet;

import java.util.List;

public interface WalletService {


    public Wallet createWallet(Integer customerId) throws CustomerDoesNotExistException, CustomerAlreadyHasWalletException;


    public Float getAccountBalanceForCurrentWallet(Integer walledId, Integer accountId) throws WalletIdDoesNotExistException, AccountNotAssociatedWithWalletException;


    public Account withdrawFromAccount(Integer walletId, Integer accountId, Float amount, String type) throws WalletIdDoesNotExistException,
            AccountNotAssociatedWithWalletException, InsufficientBalanceInWalletException;

    public Account depositToAccount(Integer walletId, Integer accountId, Float amount, String type) throws WalletIdDoesNotExistException,
            AccountNotAssociatedWithWalletException;


    public void transferToAccount(Integer fromWalletId, Integer fromAccountId, Integer toWalletId, Integer toAccountId, Float amount) throws WalletIdDoesNotExistException,
    AccountNotAssociatedWithWalletException, InsufficientBalanceInWalletException;


    public List<BankTransaction> getStatement(Integer walletId, Integer accountId, Integer n) throws WalletIdDoesNotExistException,
            AccountNotAssociatedWithWalletException;

}
