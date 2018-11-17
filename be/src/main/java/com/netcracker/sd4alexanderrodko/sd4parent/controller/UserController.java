package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AccountService accountService;

    private StudentGroupService groupService;

    @Autowired
    public UserController(AccountService accountService, StudentGroupService groupService) {
        this.accountService = accountService;
        this.groupService = groupService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getEmployerById(@PathVariable(name = "id") Long id) {
        Optional<Account> account = accountService.getEmployerById(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Account saveEmployer(@RequestBody Account employer) {
        return accountService.saveEmployer(employer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployerById(@PathVariable(name = "id") Long id) {
        accountService.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/employers", method = RequestMethod.GET)
    public Iterable<Account> getEmployers() {
        return accountService.getEmployers();
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Iterable<Account> getTeachers() {
        return accountService.getTeachers();
    }


    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public Account saveStudent(@RequestBody Student student) {
        Optional<StudentGroup> studentGroup = groupService.getGroupWithStudentsById(student.getGroupNumber());
        if (studentGroup.isPresent()) {
            Account saved = accountService.saveEmployer(student.getAccount());
            studentGroup.get().getStudents().add(student.getAccount().getUser());
            groupService.saveStudentGroup(studentGroup.get());
            return saved;
        } else {
            return new Account();
        }
    }
    @RequestMapping(value = "/students/{groupId}/{studentId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "groupId") Long groupId, @PathVariable(name = "studentId") Long studentId) {
        Optional<Account> student = accountService.getEmployerById(studentId);
        Optional<StudentGroup> studentGroup = groupService.getGroupWithStudentsById(groupId);
        if (student.isPresent() && studentGroup.isPresent()) {
            studentGroup.get().getStudents().removeIf(i -> i.getId() == studentId);
            accountService.deleteEmployer(studentId);
            groupService.saveStudentGroup(studentGroup.get());
        }
        return ResponseEntity.noContent().build();
    }
}
