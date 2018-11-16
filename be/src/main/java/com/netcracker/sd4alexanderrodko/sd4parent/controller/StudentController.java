package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts/students")
public class StudentController {

    private AccountService accountService;
    private StudentGroupService groupService;

    @Autowired
    public StudentController(AccountService accountService, StudentGroupService groupService) {
        this.accountService = accountService;
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Account> getStudents() {
        return accountService.getStudents();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Account saveStudent(@RequestBody Student student) {
        Optional<StudentGroup> studentGroup = groupService.getStudentGroupWithStudentsById(student.getGroupNumber());
        if (studentGroup.isPresent()) {
            Account saved = accountService.saveAccount(student.getAccount());
            studentGroup.get().getStudents().add(student.getAccount().getUser());
            groupService.saveStudentGroup(studentGroup.get());
            return saved;
        } else {
            return new Account();
        }
    }

}