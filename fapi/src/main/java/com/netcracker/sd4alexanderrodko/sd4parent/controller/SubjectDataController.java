package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.models.SubjectViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.SubjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectDataController {
    private SubjectDataService service;

    @Autowired
    public SubjectDataController(SubjectDataService service) {
        this.service = service;
    }


    @RequestMapping
    public List<SubjectViewModel> getPage(Integer page, Integer size,
                                                            @RequestParam(required = false, value = "abb") String abbreviation) {
        if (abbreviation != null)
            return service.findByAbbreviation(abbreviation);
        else return service.getPage(page,size);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubjectViewModel> saveSubject(@Valid @RequestBody SubjectViewModel subject) {
        return ResponseEntity.ok(service.saveSubjectViewModel(subject));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentGroup(@PathVariable long id) {
        service.deleteSubject(id);
    }

    @RequestMapping("/count")
    public Long getCount() {
        return service.count();
    }


}
