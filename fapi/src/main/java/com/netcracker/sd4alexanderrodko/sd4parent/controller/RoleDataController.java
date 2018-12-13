package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.RoleViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleDataController {


    private UserDataService userDataService;

    @Autowired
    public RoleDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }


    @RequestMapping
    public List<RoleViewModel> getRoles() {
        return userDataService.getRoles();
    }
}
