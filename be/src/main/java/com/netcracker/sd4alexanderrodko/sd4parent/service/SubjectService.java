package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Subject;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {

    Subject saveSubject(Subject subject);

    void deleteSubject(Long id);

    List<Subject> getPage(Pageable pageable);

    Iterable<Subject> findByAbbreviation(String abbreviation);

    Long count();
}
