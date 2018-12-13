package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitDataController {

    private final VisitDataService visitDataService;


    @Autowired
    public VisitDataController(VisitDataService visitDataService) {
        this.visitDataService = visitDataService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<VisitViewModel> getVisitsForLessonByGroupId(Long groupId, Long lessonId) {
        return visitDataService.getAll(groupId, lessonId);
    }

    @RequestMapping(method = RequestMethod.POST)
    Iterable<VisitViewModel> saveVisits(@RequestBody Iterable<VisitViewModel> visit) {
        return visitDataService.saveVisit(visit);
    }


}
