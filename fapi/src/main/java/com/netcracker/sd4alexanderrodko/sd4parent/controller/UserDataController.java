package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.RoleViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserDataController {

    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AccountViewModel saveEmployer(@RequestBody AccountViewModel accountViewModel) {
        return userDataService.saveEmployer(accountViewModel);
    }

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    public AccountViewModel saveStudent(@RequestBody StudentViewModel studentViewModel) {
        return userDataService.saveStudent(studentViewModel);
    }


    @RequestMapping(path = "/groups/{gr}/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(name = "gr") long groupId, @PathVariable(name = "id") long studentId) {
        userDataService.deleteStudent(groupId, studentId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployer(@PathVariable(name = "id") long employerId) {
        userDataService.deleteEmployer(employerId);
    }


    @RequestMapping()
    public List<AccountViewModel> getAll(Integer page, Integer size, @RequestParam(required = false,value="lastName") String lastName,
                                                        @RequestParam(required = false,value="roleId") String roleId) {
        if (roleId != null && !roleId.equals(""))
        return userDataService.getAllByLastNameAndRole(lastName,roleId);
        if (lastName != null && !lastName.equals(""))
            return userDataService.getAllByLastName(lastName);
        return userDataService.getAll(page, size);
    }

    @RequestMapping("/roles")
    public List<RoleViewModel> getRoles() {
        return userDataService.getRoles();
    }

    @RequestMapping("/count")
    public Long getCount() {
        return userDataService.count();
    }

    @RequestMapping("/teachers")
    public List<UserViewModel> getTeachers(String lastName) {
        return userDataService.getTeachersByLastName(lastName);
    }


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public AccountViewModel transferStudent(@RequestParam(value = "old")Long oldGroup,
                                          @RequestParam(value = "new")Long newGroup,
                                          @RequestParam(value = "id") Long id) {

        return userDataService.transferStudent(oldGroup, newGroup, id);
    }

}
