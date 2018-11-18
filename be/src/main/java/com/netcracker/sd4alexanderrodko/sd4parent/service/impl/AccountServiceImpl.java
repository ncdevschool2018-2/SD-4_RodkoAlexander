package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.AccountRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account saveEmployer(Account employer) {
        return repository.save(employer);
    }

    @Override
    public Optional<Account> getEmployerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteEmployer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<User> getTeachers() {
        return repository.getTeachers();
    }

    @Override
    public Iterable<Account> getEmployers() {
        return repository.getEmployers();
    }
}
