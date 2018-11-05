package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupToLessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupToLessonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gvisits")
public class StudentGroupToLessonDataController {
    @Autowired
    StudentGroupToLessonDataService studentGroupToLessonDataService;
    @RequestMapping
    public ResponseEntity<List<StudentGroupToLessonViewModel>> getAllStudents() {
        return ResponseEntity.ok(studentGroupToLessonDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentGroupToLessonViewModel> saveStudent(@RequestBody StudentGroupToLessonViewModel studentGroupToLessonViewModel ) {
        if (studentGroupToLessonViewModel != null) {
            return ResponseEntity.ok(studentGroupToLessonDataService.saveStudentGroupToLesson(studentGroupToLessonViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
        studentGroupToLessonDataService.deleteStudentGroupToLesson(Long.valueOf(id));
    }
}
