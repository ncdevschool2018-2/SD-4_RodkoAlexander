package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentToLessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentToLessonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/svisits")
public class StudentToLessonDataController {

    @Autowired
    StudentToLessonDataService studentToLessonDataService;
    @RequestMapping
    public ResponseEntity<List<StudentToLessonViewModel>> getAllStudents() {
        return ResponseEntity.ok(studentToLessonDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentToLessonViewModel> saveStudent(@RequestBody StudentToLessonViewModel studentToLessonViewModel ) {
        if (studentToLessonViewModel != null) {
            return ResponseEntity.ok(studentToLessonDataService.saveStudentToLesson(studentToLessonViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
        studentToLessonDataService.deleteStudentToLesson(Long.valueOf(id));
    }
}
