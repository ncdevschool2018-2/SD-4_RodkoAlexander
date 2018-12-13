package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> findUserByLastNameAndRole(@RequestParam(value = "lastName") String lastName, @RequestParam(value = "roleId") Long role) {
        return accountService.getUserByLastNameAndRole(lastName, role);
    }


}
