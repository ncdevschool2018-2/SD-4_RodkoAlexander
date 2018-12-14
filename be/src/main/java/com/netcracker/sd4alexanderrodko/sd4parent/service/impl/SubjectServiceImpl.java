package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Subject;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.SubjectRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository repository;


    @Autowired
    public SubjectServiceImpl(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return repository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Subject> getPage(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public Iterable<Subject> findByAbbreviation(String abbreviation) {
        return repository.getSubjectByAbbreviation(abbreviation);
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
