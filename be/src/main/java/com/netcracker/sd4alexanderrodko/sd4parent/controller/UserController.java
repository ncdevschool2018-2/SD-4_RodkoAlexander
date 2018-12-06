package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.*;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.LessonRepository;
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
    private LessonRepository lessonRepository;

    @Autowired
    public UserController(AccountService accountService, StudentGroupService groupService, LessonRepository lessonRepository) {
        this.accountService = accountService;
        this.groupService = groupService;
        this.lessonRepository = lessonRepository;
    }



    @RequestMapping(method = RequestMethod.POST)
    public Account saveEmployer(@RequestBody Account employer) {
        return accountService.saveEmployer(employer);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployerById(@PathVariable(name = "id") Long id) {
        Optional<Account> user = accountService.getById(id);
        if (user.isPresent()){
            if (user.get().getRole().getId() == 2){
                lessonRepository.deleteTeachersLessons(id);
            }
        }
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
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
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
        Optional<Account> student = accountService.getById(studentId);
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
