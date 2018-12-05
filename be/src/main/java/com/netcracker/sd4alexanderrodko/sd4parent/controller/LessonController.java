package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping(value = "/teacher/{teacherId}", method = RequestMethod.GET)
    public Iterable<Lesson> getLessonByTeacherId(@PathVariable(name = "teacherId") Long teacherId, Date dateFrom, Date dateTo) {
        return lessonService.getLessonsByTeacher(teacherId, dateFrom, dateTo);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Lesson> getLessons(Integer page, Integer size) {
        if (size == 0)
            return lessonService.getAll();
        else
            return lessonService.getLessonsByPage(PageRequest.of(page, size, Sort.Direction.ASC, "timeStart"));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Lesson saveLesson(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLesson(@PathVariable(name = "id") Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long getStudentsFromGroup() {
        return lessonService.count();
    }
}
