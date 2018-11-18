package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitDataController {

    @Autowired
    private VisitDataService visitDataService;


    @RequestMapping
    List<VisitViewModel> getAll() {
        return visitDataService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    VisitViewModel saveVisit(List<VisitViewModel> visits) {
        return visitDataService.saveVisit(visits);
    }
}
