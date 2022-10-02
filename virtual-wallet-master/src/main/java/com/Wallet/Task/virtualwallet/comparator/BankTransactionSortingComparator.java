package com.Wallet.Task.virtualwallet.comparator;


import com.Wallet.Task.virtualwallet.models.BankTransaction;

import java.util.Comparator;

public class BankTransactionSortingComparator implements Comparator<BankTransaction> {

    public int compare(BankTransaction t1, BankTransaction t2) {
        return t2.getTimestamp().compareTo(t1.getTimestamp());
    }
}
