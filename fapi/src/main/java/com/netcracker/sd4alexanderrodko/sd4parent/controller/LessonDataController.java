package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.LessonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ls")
public class LessonDataController {


    @Autowired
    private LessonDataService lessonDataService;

    @RequestMapping
    public ResponseEntity<List<LessonViewModel>> getAllLessons() {
        return ResponseEntity.ok(lessonDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LessonViewModel> saveLesson(@RequestBody LessonViewModel Lesson ) {
        if (Lesson != null) {
            return ResponseEntity.ok(lessonDataService.saveLesson(Lesson));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable String id) {
        lessonDataService.deleteLesson(Long.valueOf(id));
    }
}
