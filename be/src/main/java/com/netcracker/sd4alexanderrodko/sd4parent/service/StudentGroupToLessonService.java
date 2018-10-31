package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroupToLesson;

import java.util.Optional;


public interface StudentGroupToLessonService {

    StudentGroupToLesson saveStudentGroupToLesson(StudentGroupToLesson studentGroupToLesson);

    Optional<StudentGroupToLesson> getStudentGroupToLessonById(Long id);

    Iterable<StudentGroupToLesson> getAllStudentGroupToLessons();

    void deleteStudentGroupToLesson(Long id);

}
