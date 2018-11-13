package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/svisits")
public class VisitController {

    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Visit> getStudentToLessonById(@PathVariable(name = "id") Long id) {
        Optional<Visit> studentToLesson = visitService.getStudentToLessonById(id);
        if (studentToLesson.isPresent()) {
            return ResponseEntity.ok(studentToLesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Visit> getStudentToLessons() {
        return visitService.getAllStudentToLessons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Visit saveStudentToLesson(@RequestBody Visit visit) {
        return visitService.saveStudentToLesson(visit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentToLesson(@PathVariable(name = "id") Long id) {
        visitService.deleteStudentToLesson(id);
        return ResponseEntity.noContent().build();
    }
}
