package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class StudentGroupController {
    private StudentGroupService studentGroupService;

    @Autowired
    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentGroup> getStudentGroupById(@PathVariable(name = "id") Long id) {
        Optional<StudentGroup> studentGroup = studentGroupService.getStudentGroupById(id);
        if (studentGroup.isPresent()) {
            return ResponseEntity.ok(studentGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StudentGroup> getStudentGroups() {
        return studentGroupService.getAllStudentGroups();
    }

    @RequestMapping(method = RequestMethod.POST)
    public StudentGroup saveStudentGroup(@RequestBody StudentGroup studentGroup) {
        return studentGroupService.saveStudentGroup(studentGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentGroup(@PathVariable(name = "id") Long id) {
        studentGroupService.deleteStudentGroup(id);
        return ResponseEntity.noContent().build();
    }
}
