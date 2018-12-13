package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.ScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<LessonViewModel> getAllLessons(int page, int size) {
        return scheduleDataService.getAll(page, size);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LessonViewModel> saveLesson(@Valid @RequestBody LessonViewModel lessonViewModel) {
        if (lessonViewModel != null) {
            return ResponseEntity.ok(scheduleDataService.saveLesson(lessonViewModel));
        }
        return null;
    }

    @RequestMapping("/count")
    public Long getCount() {
        return scheduleDataService.count();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable String id) {
        scheduleDataService.deleteLesson(Long.valueOf(id));
    }

    @RequestMapping(value = "/teacher/{teacherId}", method = RequestMethod.GET)
    public ResponseEntity<List<LessonViewModel>> getLessonsByTeacherId(@PathVariable long teacherId, String dateFrom, String dateTo) {
        return ResponseEntity.ok(scheduleDataService.getLessonsByTeacherId(teacherId, dateFrom, dateTo));
    }

    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<List<LessonViewModel>> getLessonsByGroupId(@PathVariable long groupId, String dateFrom, String dateTo) {
        return ResponseEntity.ok(scheduleDataService.getLessonsByGroupId(groupId, dateFrom, dateTo));
    }
}
