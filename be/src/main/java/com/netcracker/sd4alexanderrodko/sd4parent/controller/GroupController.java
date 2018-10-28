package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Group;
import com.netcracker.sd4alexanderrodko.sd4parent.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Group> getStudentGroupById(@PathVariable(name = "id") Long id) {
        Optional<Group> studentGroup = groupService.getStudentGroupById(id);
        if (studentGroup.isPresent()) {
            return ResponseEntity.ok(studentGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Group> getStudentGroups() {
        return groupService.getAllStudentGroups();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Group saveStudentGroup(@RequestBody Group group) {
        return groupService.saveStudentGroup(group);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentGroup(@PathVariable(name = "id") Long id) {
        groupService.deleteStudentGroup(id);
        return ResponseEntity.noContent().build();
    }
}
