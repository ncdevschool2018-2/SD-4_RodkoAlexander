package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroupToLesson;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupToLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/gvisits")
public class StudentGroupToLessonController {

    private StudentGroupToLessonService studentGroupToLessonService;

    @Autowired
    public StudentGroupToLessonController(StudentGroupToLessonService studentGroupToLessonService) {
        this.studentGroupToLessonService = studentGroupToLessonService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentGroupToLesson> getStudentGroupToLessonById(@PathVariable(name = "id") Long id) {
        Optional<StudentGroupToLesson> studentGroupToLesson = studentGroupToLessonService.getStudentGroupToLessonById(id);
        if (studentGroupToLesson.isPresent()) {
            return ResponseEntity.ok(studentGroupToLesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StudentGroupToLesson> getStudentGroupToLessons() {
        return studentGroupToLessonService.getAllStudentGroupToLessons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public StudentGroupToLesson saveStudentGroupToLesson(@RequestBody StudentGroupToLesson studentGroupToLesson) {
        return studentGroupToLessonService.saveStudentGroupToLesson(studentGroupToLesson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentGroupToLesson(@PathVariable(name = "id") Long id) {
        studentGroupToLessonService.deleteStudentGroupToLesson(id);
        return ResponseEntity.noContent().build();
    }
}
