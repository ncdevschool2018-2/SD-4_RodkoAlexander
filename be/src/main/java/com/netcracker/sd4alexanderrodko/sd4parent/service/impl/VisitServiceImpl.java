package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.StudentGroupRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.VisitRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VisitServiceImpl implements VisitService {
    private VisitRepository visitRepository;
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository, StudentGroupRepository studentGroupRepository) {
        this.visitRepository = visitRepository;
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public List<Visit> saveVisits(Iterable<Visit> visits) {
        return visitRepository.saveAll(visits);
    }


    @Override
    public List<Visit> getVisitsForLessonAndGroup(long groupId, long lessonId) {
        return visitRepository.getVisitByGroupIdAndLessonId(
                studentGroupRepository.getStudentsFromGroupById(groupId),
                lessonId);
    }


}
