package com.Wallet.Task.virtualwallet.controller;

import com.Wallet.Task.virtualwallet.models.Account;
import com.Wallet.Task.virtualwallet.repository.AccountRepository;
import com.Wallet.Task.virtualwallet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/api/account")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

}
