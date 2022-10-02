package com.Wallet.Task.virtualwallet.repository;

import com.Wallet.Task.virtualwallet.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("SELECT a FROM Account  a WHERE a.accountNumber=:accountNumber")
    Iterable<Account> findAccountByNumber(@Param("accountNumber") Integer accountNumber);
}
