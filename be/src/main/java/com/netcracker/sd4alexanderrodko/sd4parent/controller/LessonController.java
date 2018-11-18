package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping(value = "/teacher/{teacherId}", method = RequestMethod.GET)
    public Iterable<Lesson> getLessonByTeacherId(@PathVariable(name = "teacherId") Long teacherId) {
        return lessonService.getLessonsByTeacher(teacherId);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Lesson> getLessons() {
        return lessonService.getAllLessons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Lesson saveLesson(@RequestBody Lesson lesson) {
        System.out.println(lesson.toString());
        return lessonService.saveLesson(lesson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLesson(@PathVariable(name = "id") Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
