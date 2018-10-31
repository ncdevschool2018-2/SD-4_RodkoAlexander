package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentToLesson;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentToLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/visits")
public class StudentToLessonController {

    private StudentToLessonService studentToLessonService;

    @Autowired
    public StudentToLessonController(StudentToLessonService studentToLessonService) {
        this.studentToLessonService = studentToLessonService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentToLesson> getStudentToLessonById(@PathVariable(name = "id") Long id) {
        Optional<StudentToLesson> studentToLesson = studentToLessonService.getStudentToLessonById(id);
        if (studentToLesson.isPresent()) {
            return ResponseEntity.ok(studentToLesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StudentToLesson> getStudentToLessons() {
        return studentToLessonService.getAllStudentToLessons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public StudentToLesson saveStudentToLesson(@RequestBody StudentToLesson studentToLesson) {
        return studentToLessonService.saveStudentToLesson(studentToLesson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentToLesson(@PathVariable(name = "id") Long id) {
        studentToLessonService.deleteStudentToLesson(id);
        return ResponseEntity.noContent().build();
    }
}
