package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;


    @RequestMapping
    public ResponseEntity<Iterable<UserViewModel>> getAllUsers() {
        return ResponseEntity.ok(userDataService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveUser(@RequestBody UserViewModel userViewModel) {
        if (userViewModel != null) {
            return ResponseEntity.ok(userDataService.saveUser(userViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userDataService.deleteUser(Long.valueOf(id));
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserViewModel>> getTeachers() {
        return ResponseEntity.ok(userDataService.getTeachers());
    }

    @RequestMapping(value = "/administrators", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserViewModel>> getAdministrators() {
        return ResponseEntity.ok(userDataService.getAdministrators());
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserViewModel>> getStudents() {
        return ResponseEntity.ok(userDataService.getStudents());
    }
}
