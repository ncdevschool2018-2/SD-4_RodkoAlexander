package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Role;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private AccountService accountService;


    @Autowired
    public RoleController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Role> getRoles() {
        return accountService.getRoles();
    }
}
