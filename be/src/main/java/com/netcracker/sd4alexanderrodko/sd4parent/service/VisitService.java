package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;

import java.util.Optional;


public interface VisitService {

    Visit saveVisit(Visit visit);

    Optional<Visit> getVisitsById(Long id);

    Iterable<Visit> getAllVisits();

    void deleteVisitsById(Long id);
}
