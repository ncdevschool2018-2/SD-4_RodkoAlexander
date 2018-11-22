package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.ScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleDataController {

    private final ScheduleDataService scheduleDataService;

    @Autowired
    public ScheduleDataController(ScheduleDataService scheduleDataService) {
        this.scheduleDataService = scheduleDataService;
    }

    @RequestMapping
    public ResponseEntity<List<LessonViewModel>> getAllLessons() {
        return ResponseEntity.ok(scheduleDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LessonViewModel> saveLesson(@RequestBody LessonViewModel lessonViewModel) {
        System.out.println(lessonViewModel);
        if (lessonViewModel != null) {
            return ResponseEntity.ok(scheduleDataService.saveLesson(lessonViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable String id) {
        scheduleDataService.deleteLesson(Long.valueOf(id));
    }

    @RequestMapping(value = "/teacher/{teacherId}")
    public ResponseEntity<List<LessonViewModel>> getLessonsByTeacherId(@PathVariable long teacherId) {
        return ResponseEntity.ok(scheduleDataService.getLessonsByTeacherId(teacherId));
    }

    @RequestMapping(value = "/group/{groupId}")
    public ResponseEntity<List<LessonViewModel>> getLessonsByGroupId(@PathVariable long groupId) {
        return ResponseEntity.ok(scheduleDataService.getLessonsByGroupId(groupId));
    }
}
