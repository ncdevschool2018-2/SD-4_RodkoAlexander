package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;

import java.util.Optional;


public interface VisitService {

    Visit saveStudentToLesson(Visit visit);

    Optional<Visit> getStudentToLessonById(Long id);

    Iterable<Visit> getAllStudentToLessons();

    void deleteStudentToLesson(Long id);

}
