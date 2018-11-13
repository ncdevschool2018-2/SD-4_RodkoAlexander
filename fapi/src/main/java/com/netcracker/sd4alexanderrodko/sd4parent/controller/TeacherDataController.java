package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.TeacherViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherDataController {
    @Autowired
    TeacherDataService teacherDataService;
    @RequestMapping
    public ResponseEntity<List<TeacherViewModel>> getAllStudents() {
        return ResponseEntity.ok(teacherDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TeacherViewModel> saveStudent(@RequestBody TeacherViewModel teacherViewModel ) {

        if (teacherViewModel != null) {
            return ResponseEntity.ok(teacherDataService.saveTeacher(teacherViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
        teacherDataService.deleteTeacher(Long.valueOf(id));
    }
}
