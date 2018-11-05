package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountDataController {
    @Autowired
    private AccountDataService accountDataService;


    @RequestMapping
    public ResponseEntity<List<AccountViewModel>> getAllAccounts() {
        return ResponseEntity.ok(accountDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountViewModel> saveAccount(@RequestBody AccountViewModel accountViewModel) {
        if (accountViewModel != null) {
            return ResponseEntity.ok(accountDataService.saveAccount(accountViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String id) {
        accountDataService.deleteAccount(Long.valueOf(id));
    }
}
