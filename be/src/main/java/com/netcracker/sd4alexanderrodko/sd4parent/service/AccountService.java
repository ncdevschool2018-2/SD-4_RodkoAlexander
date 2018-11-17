package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;

import java.util.Optional;

public interface AccountService {

    Account saveEmployer(Account employer);

    Optional<Account> getEmployerById(Long id);

    void deleteEmployer(Long id);

    Iterable<Account> getEmployers();

    Iterable<Account> getTeachers();

}
