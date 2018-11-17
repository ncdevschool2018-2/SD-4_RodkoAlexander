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


    @RequestMapping(path = "/students",method = RequestMethod.DELETE)
    public void deleteStudent(long groupId, long studentId) {
        userDataService.deleteStudent(groupId,studentId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteEmployer(long employerId) {
        userDataService.deleteEmployer(employerId);
    }

    @RequestMapping("/employers")
    public List<AccountViewModel> getEmployers() {
        return userDataService.getEmployers();
    }

    @RequestMapping("/teachers")
    public List<AccountViewModel> getTeachers() {
        return userDataService.getTeachers();
    }

    @RequestMapping("/{groupId}/students")
    public List<UserViewModel> getStudentsFromGroup(@PathVariable long groupId) {
        return userDataService.getStudentsFromGroup(groupId);
    }
}
