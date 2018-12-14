package com.netcracker.sd4alexanderrodko.sd4parent.controller;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Subject;
import com.netcracker.sd4alexanderrodko.sd4parent.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {


    private SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Subject> getALL(Integer page, Integer size,
                                    @RequestParam(required = false, value = "abb") String abb) {
        if (abb != null)
            return service.findByAbbreviation(abb);
        else return service.getPage(PageRequest.of(page, size, new Sort(Sort.DEFAULT_DIRECTION, "id")));
    }


    @RequestMapping(method = RequestMethod.POST)
    public Subject saveSubject(@RequestBody Subject subject) {
        return service.saveSubject(subject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLesson(@PathVariable(name = "id") Long id) {
        service.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long getStudentsFromGroup() {
        return service.count();
    }
}
