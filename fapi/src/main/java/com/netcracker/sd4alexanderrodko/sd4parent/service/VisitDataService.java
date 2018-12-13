package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;

import java.util.List;

public interface VisitDataService {
    Iterable<VisitViewModel> getAll(Long groupId,Long lessonId);
    Iterable<VisitViewModel> saveVisit(Iterable<VisitViewModel> visits);
}
