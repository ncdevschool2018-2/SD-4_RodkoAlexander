package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class EmployerController {

    private AccountService service;

    @Autowired
    public EmployerController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable(name = "id") Long id) {
        Optional<Account> account = service.getAccountById(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Account> getAccounts() {
        return service.getAllAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account employer) {
        return service.saveAccount(employer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable(name = "id") Long id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Iterable<Account> getTeachers() {
        return service.getTeachers();
    }

    @RequestMapping(value = "/administrators", method = RequestMethod.GET)
    public Iterable<Account> getAdministrators() {
        return service.getAdministrators();
    }

    @RequestMapping(value = "/employers", method = RequestMethod.GET)
    public Iterable<Account> getEmployers() {
        return service.getEmployers();
    }
}
