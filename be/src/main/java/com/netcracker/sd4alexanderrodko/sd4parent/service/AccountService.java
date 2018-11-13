package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;

import java.util.Optional;

public interface AccountService {
    Account saveAccount(Account account);

    Optional<Account> getAccountById(Long id);

    Iterable<Account> getAllAccounts();

    void deleteAccount(Long id);
}
