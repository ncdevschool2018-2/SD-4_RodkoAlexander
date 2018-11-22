package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Role;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.AccountRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.RoleRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService , RoleService {

    private AccountRepository accountRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Account saveEmployer(Account employer) {
        return accountRepository.save(employer);
    }

    @Override
    public Optional<Account> getEmployerById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteEmployer(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getTeachers() {
        return accountRepository.getTeachers();
    }

    @Override
    public Optional<Account> login(String email) {
        return accountRepository.isExists(email);
    }

    @Override
    public Iterable<Account> getEmployers() {
        return accountRepository.getEmployers();
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}
