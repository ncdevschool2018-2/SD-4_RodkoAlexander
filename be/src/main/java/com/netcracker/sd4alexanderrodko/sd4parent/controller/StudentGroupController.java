package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return studentGroupService.getStudentsByGroupId(groupId);
    }
    @RequestMapping(value = "/{groupId}/lessons", method = RequestMethod.GET)
    public Iterable<Lesson> getLessonByGroupId(@PathVariable(name = "groupId") Long groupId) {
        return studentGroupService.getLessonsByGroupId(groupId);
    }
    @RequestMapping(value = "/descriptions", method = RequestMethod.GET)
    public Iterable<StudentGroup> getStudentGroupsDescriptions() {
        return studentGroupService.getDescriptions();
    }


    @RequestMapping(method = RequestMethod.POST)
    public StudentGroup saveStudentGroup(@RequestBody StudentGroup studentGroup) {
        return studentGroupService.saveStudentGroup(studentGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentGroup(@PathVariable(name = "id") Long id) {
        studentGroupService.deleteStudentGroup(id);
        return ResponseEntity.noContent().build();
    }
}
