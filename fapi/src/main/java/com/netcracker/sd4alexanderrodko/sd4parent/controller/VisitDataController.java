package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/svisits")
public class VisitDataController {

    @Autowired
    VisitDataService visitDataService;
    @RequestMapping
    public ResponseEntity<List<VisitViewModel>> getAllStudents() {
        return ResponseEntity.ok(visitDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VisitViewModel> saveStudent(@RequestBody VisitViewModel visitViewModel) {
        if (visitViewModel != null) {
            return ResponseEntity.ok(visitDataService.saveStudentToLesson(visitViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
        visitDataService.deleteStudentToLesson(Long.valueOf(id));
    }
}
