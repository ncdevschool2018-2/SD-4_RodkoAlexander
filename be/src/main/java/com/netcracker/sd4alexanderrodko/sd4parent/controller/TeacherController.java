package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Teacher;
import com.netcracker.sd4alexanderrodko.sd4parent.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.Temporal;
import java.util.Optional;


@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(name = "id") Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Teacher> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeacher(@PathVariable(name = "id") Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}