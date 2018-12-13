package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountDataController {

    private UserDataService userDataService;

    @Autowired
    public AccountDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AccountViewModel saveEmployer(@Valid @RequestBody AccountViewModel accountViewModel) {
        return userDataService.saveEmployer(accountViewModel);
    }

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public AccountViewModel saveStudent(@Valid @RequestBody StudentViewModel studentViewModel) {
        return userDataService.saveStudent(studentViewModel);
    }


    @RequestMapping(path = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent( @PathVariable(name = "id") long studentId) {
        userDataService.deleteStudent(studentId);
    }


    @RequestMapping(path = "/students", method = RequestMethod.PUT)
    public void transferStudent( @RequestParam(value = "new") Long newGroup,
                                 @RequestParam(value = "id") Long id) {
        userDataService.transferStudent(newGroup, id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployer(@PathVariable(name = "id") long employerId) {
        userDataService.deleteEmployer(employerId);
    }


    @RequestMapping()
    public List<AccountViewModel> getAll(Integer page, Integer size, @RequestParam(required = false, value = "lastName") String lastName,
                                         @RequestParam(required = false, value = "roleId") Long roleId) {
        if (roleId != null && lastName != null && !lastName.equals(""))
            return userDataService.getAccountsByLastNameAndRole(lastName, roleId);
        return userDataService.getAll(page, size);
    }


    @RequestMapping("/count")
    public Long getCount() {
        return userDataService.count();
    }
}
