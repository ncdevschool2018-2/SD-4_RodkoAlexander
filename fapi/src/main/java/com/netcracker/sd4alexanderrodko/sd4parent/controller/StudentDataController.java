package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentDataController {
    @Autowired
    private StudentDataService studentDataService;


    @RequestMapping
    public ResponseEntity<List<StudentViewModel>> getAllStudents() {
        return ResponseEntity.ok(studentDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentViewModel> saveStudent(@RequestBody StudentViewModel studentViewModel ) {
        if (studentViewModel != null) {
            return ResponseEntity.ok(studentDataService.saveStudent(studentViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<StudentViewModel> saveStudentWithAccount(@RequestBody StudentViewModel studentViewModel ) {
        if (studentViewModel != null) {
            return ResponseEntity.ok(studentDataService.saveStudentWithAccount(studentViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
        studentDataService.deleteStudent(Long.valueOf(id));
    }
}
