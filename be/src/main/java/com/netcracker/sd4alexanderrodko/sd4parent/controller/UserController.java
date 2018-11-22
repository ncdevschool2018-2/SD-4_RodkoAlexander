package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.*;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.RoleService;
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
    private RoleService roleService;

    @Autowired
    public UserController(AccountService accountService, StudentGroupService groupService, RoleService roleService) {
        this.accountService = accountService;
        this.groupService = groupService;
        this.roleService = roleService;
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

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public Iterable<Role> getRoles() {
        return roleService.findAll();
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Iterable<User> getTeachers() {
        return accountService.getTeachers();
    }


    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public Account saveStudent(@RequestBody Student student) {
        Optional<StudentGroup> studentGroup = groupService.getGroupWithStudentsByid(student.getGroupId());
        if (studentGroup.isPresent()) {
            Account saved = accountService.saveEmployer(student.getAccount());
            studentGroup.get().getUsers().add(student.getAccount().getUser());
            groupService.saveStudentGroup(studentGroup.get());
            return saved;
        } else {
            return new Account();
        }
    }
    @RequestMapping(value = "/students/{groupId}/{studentId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "groupId") Long groupId, @PathVariable(name = "studentId") Long studentId) {
        Optional<Account> student = accountService.getEmployerById(studentId);
        Optional<StudentGroup> studentGroup = groupService.getGroupWithStudentsByid(groupId);
        if (student.isPresent() && studentGroup.isPresent()) {
            studentGroup.get().getUsers().removeIf(i -> i.getId() == studentId);
            accountService.deleteEmployer(studentId);
            groupService.saveStudentGroup(studentGroup.get());
        }
        return ResponseEntity.noContent().build();
    }
}
