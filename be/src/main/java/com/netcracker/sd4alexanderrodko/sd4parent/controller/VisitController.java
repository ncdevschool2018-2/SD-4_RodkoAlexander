package com.netcracker.sd4alexanderrodko.sd4parent.controller;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Visit> getVisitById(@PathVariable(name = "id") Long id) {
        Optional<Visit> visit = visitService.getVisitById(id);
        if (visit.isPresent()) {
            return ResponseEntity.ok(visit.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Visit> getVisits() {
        return visitService.getAllVisits();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Visit saveVisit(@RequestBody Visit visit) {
        return visitService.saveVisit(visit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteVisit(@PathVariable(name = "id") Long id) {
        visitService.deleteVisit(id);
        return ResponseEntity.noContent().build();
    }
}
