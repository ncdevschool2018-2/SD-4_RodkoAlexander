package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @RequestMapping("/{id}")
    public AccountViewModel getEmployerById(@PathVariable long id) {
           return userDataService.getEmployerById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AccountViewModel saveEmployer(@RequestBody AccountViewModel accountViewModel) {
        return userDataService.saveEmployer(accountViewModel);
    }

    @RequestMapping(path = "/students",method = RequestMethod.POST)
    public AccountViewModel saveStudent(@RequestBody StudentViewModel studentViewModel) {
        return userDataService.saveStudent(studentViewModel);
    }


    @RequestMapping(path = "/students/{gr}/{id}",method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(name = "gr")long groupId,@PathVariable(name = "id") long studentId) {
        userDataService.deleteStudent(groupId,studentId);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public void deleteEmployer(@PathVariable(name = "id") long employerId) {
        userDataService.deleteEmployer(employerId);
    }

    @RequestMapping("/employers")
    public List<AccountViewModel> getEmployers() {
        return userDataService.getEmployers();
    }

    @RequestMapping("/teachers")
    public List<UserViewModel> getTeachers() {
        return userDataService.getTeachers();
    }

}
