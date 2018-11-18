package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupDataService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class StudentGroupDataController {

    @Autowired
    private StudentGroupDataService studentGroupDataService;
    @Autowired
    private UserDataService userDataService;

    @RequestMapping
    public ResponseEntity<List<StudentGroupViewModel>> getGroupsWithDescriptions() {
        return ResponseEntity.ok(studentGroupDataService.getDescriptions());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentGroupViewModel> saveStudentGroup(@RequestBody StudentGroupViewModel studentGroupViewModel) {
        if (studentGroupViewModel != null) {
            return ResponseEntity.ok(studentGroupDataService.saveStudentGroup(studentGroupViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentGroup(@PathVariable long id) {
        studentGroupDataService.deleteStudentGroup(id);
    }

    @RequestMapping("/{groupId}/students")
    public List<UserViewModel> getStudentsFromGroup(@PathVariable long groupId) {
        return userDataService.getStudentsFromGroup(groupId);
    }


}
