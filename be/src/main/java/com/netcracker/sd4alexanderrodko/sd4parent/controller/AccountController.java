package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.LessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    private StudentGroupService groupService;
    private LessonRepository lessonRepository;

    @Autowired
    public AccountController(AccountService accountService, StudentGroupService groupService, LessonRepository lessonRepository) {
        this.accountService = accountService;
        this.groupService = groupService;
        this.lessonRepository = lessonRepository;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Account saveEmployer(@RequestBody Account employer) {
        if (accountService.checkDuplicate(employer.getEmail()))
        return accountService.saveEmployer(employer);
        else return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
        Optional<Account> user = accountService.getById(id);
        if (user.isPresent()) {
            if (user.get().getRole().getId() == 2) {
                lessonRepository.deleteTeachersLessons(id);
            }
        }
        accountService.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Account> getALL(Integer page, Integer size,
                                    @RequestParam(required = false, value = "lastName") String lastName,
                                    @RequestParam(required = false, value = "roleId") Long roleId) {
        if (roleId != null && lastName != null) {
            if (roleId == 0)
                return accountService.findByLastName(lastName);
            return accountService.getAccountByLastNameAndRole(lastName, roleId);
        } else if (size == 0)
            return accountService.getAll();
        else
            return accountService.getAllByPage(PageRequest.of(page, size, new Sort(Sort.DEFAULT_DIRECTION, "id")));
    }


    @RequestMapping(value = "/students", method = RequestMethod.PUT)
    public ResponseEntity transferStudent(@RequestParam(value = "new") Long newGroup,
                                          @RequestParam(value = "id") Long id) {
        Optional<StudentGroup> oldStudentGroup = groupService.getGroupByStudent(id);
        Optional<Account> student = accountService.getById(id);
        Optional<StudentGroup> newStudentGroup = groupService.getGroupWithStudentsById(newGroup);
        if (oldStudentGroup.isPresent() && newStudentGroup.isPresent() && student.isPresent()) {
            oldStudentGroup.get().getUsers().removeIf(i -> i.getId() == id);
            newStudentGroup.get().getUsers().add(student.get().getUser());
            groupService.saveStudentGroup(oldStudentGroup.get());
            groupService.saveStudentGroup(newStudentGroup.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Account saveStudent(@RequestBody Student student) {
        if (accountService.checkDuplicate(student.getAccount().getEmail())) {
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
        else return null;
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable(name = "studentId") Long studentId) {
        Optional<Account> student = accountService.getById(studentId);
        Optional<StudentGroup> studentGroup = groupService.getGroupByStudent(studentId);
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
