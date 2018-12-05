package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;

import java.util.List;


public interface VisitService {

    List<Visit> saveVisits(Iterable<Visit> visit);

    List<Visit> getVisitsForLessonAndGroup(long groupId, long lessonId);

}
