package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.VisitRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class VisitServiceImpl implements VisitService {
    private VisitRepository repository;

    @Autowired
    public VisitServiceImpl(VisitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Visit saveVisit(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public Optional<Visit> getVisitsById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Visit> getAllVisits() {
        return repository.findAll();
    }

    @Override
    public void deleteVisitsById(Long id) {
        repository.deleteById(id);
    }
}
