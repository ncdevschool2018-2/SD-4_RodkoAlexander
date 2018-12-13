package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Role;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.AccountRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.RoleRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

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
    public Optional<Account> getById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteEmployer(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<User> getUserByLastNameAndRole(String lastName, Long role) {
        return accountRepository.getTeachersByLastName(lastName,role);
    }


    @Override
    public Optional<Account> login(String email) {
        return accountRepository.isExists(email);
    }

    @Override
    public long count() {
        return accountRepository.count();
    }


    @Override
    public List<Account> getAllByPage(Pageable pageable) {
        return accountRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findByLastName(String lastName) {
        return accountRepository.findAccountsByUserLastName(lastName);
    }

    @Override
    public List<Account> getAccountByLastNameAndRole(String lastName, Long roleId) {
        return accountRepository.findAccountsByUserLastNameAndRole(lastName, roleId);
    }

    @Override
    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public boolean checkDuplicate(String email) {
        return accountRepository.check(email) == 0;
    }
}
