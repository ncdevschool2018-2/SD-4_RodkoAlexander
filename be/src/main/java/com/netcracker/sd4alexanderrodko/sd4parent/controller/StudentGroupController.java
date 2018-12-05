package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class StudentGroupController {
    private StudentGroupService studentGroupService;

    @Autowired
    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @RequestMapping(value = "/{groupId}/students", method = RequestMethod.GET)
    public Iterable<User> getStudentsFromGroup(@PathVariable(name = "groupId") Long groupId) {
        return studentGroupService.getStudentsById(groupId);
    }


    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long getStudentsFromGroup() {
        return studentGroupService.count();
    }

    @RequestMapping(value = "/{groupId}/lessons", method = RequestMethod.GET)
    public Iterable<Lesson> getLessonByGroupId(@PathVariable(name = "groupId") Long groupId, Date dateFrom, Date dateTo) {
        return studentGroupService.getLessonsById(groupId, dateFrom, dateTo);
    }

    @RequestMapping(value = "/descriptions", method = RequestMethod.GET)
    public Iterable<StudentGroup> getStudentGroupsDescriptionsPage(Integer page, Integer size,
                                                                   @RequestParam(required = false, value = "number") Long number,

                                                                   @RequestParam(required = false, value = "course") Integer course) {
        if (course != null) {
            return studentGroupService.findByCourse(course);
        } else
        if (number != null) {
            return studentGroupService.findById(number);
        } else if (size == 0) {
            return studentGroupService.getDescriptions();
        } else {
            return studentGroupService.getDescriptionsPage(PageRequest.of(page, size, new Sort(Sort.DEFAULT_DIRECTION, "id")));
        }

    }


    @RequestMapping(method = RequestMethod.POST)
    public StudentGroup saveStudentGroup(@RequestBody StudentGroup studentGroup) {
        Optional<StudentGroup> ifPresent = studentGroupService.getGroupWithStudentsById(studentGroup.getId());
        if (ifPresent.isPresent()) {
            ifPresent.get().setCourse(studentGroup.getCourse());
            ifPresent.get().setDescription(studentGroup.getDescription());
            return studentGroupService.saveStudentGroup(ifPresent.get());
        }
        return studentGroupService.saveStudentGroup(studentGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentGroup(@PathVariable(name = "id") Long id) {
        studentGroupService.deleteStudentGroup(id);
        return ResponseEntity.noContent().build();
    }
}
