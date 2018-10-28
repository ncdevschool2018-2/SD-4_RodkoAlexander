package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.GroupToLesson;
import com.netcracker.sd4alexanderrodko.sd4parent.service.GroupToLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/gtl")
public class GroupToLessonController {
    private GroupToLessonService groupToLessonService;

    @Autowired
    public GroupToLessonController(GroupToLessonService groupToLessonService) {
        this.groupToLessonService = groupToLessonService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GroupToLesson> getGroupToLessonById(@PathVariable(name = "id") Long id) {
        Optional<GroupToLesson> groupToLesson = groupToLessonService.getGroupToLessonById(id);
        if (groupToLesson.isPresent()) {
            return ResponseEntity.ok(groupToLesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<GroupToLesson> getGroupToLessons() {
        return groupToLessonService.getAllGroupToLessons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public GroupToLesson saveGroupToLesson(@RequestBody GroupToLesson groupToLesson) {
        return groupToLessonService.saveGroupToLesson(groupToLesson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteGroupToLesson(@PathVariable(name = "id") Long id) {
        groupToLessonService.deleteGroupToLesson(id);
        return ResponseEntity.noContent().build();
    }

}
