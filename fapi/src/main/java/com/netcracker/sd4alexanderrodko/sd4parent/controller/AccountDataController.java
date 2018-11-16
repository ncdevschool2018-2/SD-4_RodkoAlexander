package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
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
    public ResponseEntity<AccountViewModel> saveAccount(@RequestBody AccountViewModel account) {
        if (account != null) {
            return ResponseEntity.ok(accountDataService.saveAccount(account));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/students")
    public ResponseEntity<AccountViewModel> saveStudent(@RequestBody StudentViewModel student) {
        if (student != null) {
            return ResponseEntity.ok(accountDataService.saveStudent(student));
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String id) {
        accountDataService.deleteAccount(Long.valueOf(id));
    }
}
