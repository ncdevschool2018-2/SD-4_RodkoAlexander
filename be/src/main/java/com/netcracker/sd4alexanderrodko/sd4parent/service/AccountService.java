package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;

import java.util.Optional;

public interface AccountService {
    Account saveAccount(Account account);

    Optional<Account> getAccountById(Long id);

    Iterable<Account> getAllAccounts();

    Iterable<Account> getEmployers();

    void deleteAccount(Long id);

    long count();

    Iterable<Account> getStudents();

    Iterable<Account> getTeachers();

    Iterable<Account> getAdministrators();
}
