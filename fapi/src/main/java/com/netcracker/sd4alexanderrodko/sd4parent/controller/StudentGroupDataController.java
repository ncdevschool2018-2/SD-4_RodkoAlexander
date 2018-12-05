package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupDataService;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class StudentGroupDataController {

    private final StudentGroupDataService studentGroupDataService;
    private final UserDataService userDataService;

    @Autowired
    public StudentGroupDataController(StudentGroupDataService studentGroupDataService, UserDataService userDataService) {
        this.studentGroupDataService = studentGroupDataService;
        this.userDataService = userDataService;
    }

    @RequestMapping
    public List<StudentGroupViewModel> getGroupsWithDescriptions(Integer page,Integer size,
                                                                                 @RequestParam(required = false, value = "number") String number,
                                                                 @RequestParam(required = false, value = "course") Integer course) {
        if (number != null && !number.equals(""))
            return studentGroupDataService.findByGroupNumber(number);
        if (course != null)
            return studentGroupDataService.findGroupsByCourse(course);
        return studentGroupDataService.getDescriptions(page,size);
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

    @RequestMapping("/count")
    public Long getCount() {
        return studentGroupDataService.count();
    }

}
