package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.*;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @RequestMapping(method = RequestMethod.POST)
    public Account saveEmployer(@RequestBody Account employer) {
        return accountService.saveEmployer(employer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployerById(@PathVariable(name = "id") Long id) {
        accountService.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Account> getALL(Integer page, Integer size,
                                    @RequestParam(required = false, value = "lastName") String lastName,
                                    @RequestParam(required = false, value = "roleId") Integer roleId) {
        if (roleId != null && lastName != null)
            return accountService.findByLastNameAndRole(lastName, roleId);
        else if (lastName != null)
            return accountService.findByLastName(lastName);
        else if (size == 0)
            return accountService.getAll();
        else
            return accountService.getAllByPage(PageRequest.of(page, size, new Sort(Sort.DEFAULT_DIRECTION, "id")));
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public Iterable<Role> getRoles() {
        return accountService.getRoles();
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Iterable<User> getTeachersByLastName(@RequestParam(value = "lastName") String lastName) {
        return accountService.getFindTeacherByLastName(lastName);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity transferStudent(@RequestParam(value = "old")Long oldGroup,
                                          @RequestParam(value = "new")Long newGroup,
                                          @RequestParam(value = "id")Long id) {
        Optional<StudentGroup> oldStudentGroup = groupService.getGroupWithStudentsById(oldGroup);
        Optional<StudentGroup> newStudentGroup = groupService.getGroupWithStudentsById(newGroup);
        Optional<Account> student = accountService.getEmployerById(id);
        if (oldStudentGroup.isPresent() && newStudentGroup.isPresent() && student.isPresent()) {
            if (oldStudentGroup.get().getUsers().contains(student.get().getUser())) {
                oldStudentGroup.get().getUsers().removeIf(i -> i.getId() == student.get().getId());
                newStudentGroup.get().getUsers().add(student.get().getUser());
                groupService.saveStudentGroup(oldStudentGroup.get());
                groupService.saveStudentGroup(newStudentGroup.get());
                return ResponseEntity.ok(student.get());
            }
            else return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Account saveStudent(@RequestBody Student student) {
        Optional<StudentGroup> studentGroup = groupService.getGroupWithStudentsById(student.getGroupId());
        if (studentGroup.isPresent()) {
            Account saved = accountService.saveEmployer(student.getAccount());
            studentGroup.get().getUsers().add(student.getAccount().getUser());
            groupService.saveStudentGroup(studentGroup.get());
            return saved;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/students/{groupId}/{studentId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "groupId") Long groupId, @PathVariable(name = "studentId") Long studentId) {
        Optional<Account> student = accountService.getEmployerById(studentId);
        Optional<StudentGroup> studentGroup = groupService.getGroupWithStudentsById(groupId);
        if (student.isPresent() && studentGroup.isPresent()) {
            studentGroup.get().getUsers().removeIf(i -> i.getId() == studentId);
            accountService.deleteEmployer(studentId);
            groupService.saveStudentGroup(studentGroup.get());
        }
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long getStudentsFromGroup() {
        return accountService.count();
    }
}
