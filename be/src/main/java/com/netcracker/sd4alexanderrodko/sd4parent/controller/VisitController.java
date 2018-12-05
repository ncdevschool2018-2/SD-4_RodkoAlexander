package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Visit> getVisitsForLessonByGroupId(Long groupId, Long lessonId) {
        return visitService.getVisitsForLessonAndGroup(groupId, lessonId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Iterable<Visit> saveVisits(@RequestBody Iterable<Visit> visit) {
        return visitService.saveVisits(visit);
    }

}
