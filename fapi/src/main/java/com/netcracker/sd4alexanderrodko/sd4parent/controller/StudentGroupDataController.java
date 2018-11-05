package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class StudentGroupDataController {

    @Autowired
    StudentGroupDataService studentGroupDataService;
    @RequestMapping
    public ResponseEntity<List<StudentGroupViewModel>> getAllGroups() {
        return ResponseEntity.ok(studentGroupDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentGroupViewModel> saveGroup(@RequestBody StudentGroupViewModel studentGroupViewModel ) {
        if (studentGroupViewModel != null) {
            return ResponseEntity.ok(studentGroupDataService.saveStudentGroup(studentGroupViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteGroup(@PathVariable String id) {
        studentGroupDataService.deleteStudentGroup(Long.valueOf(id));
    }
}
