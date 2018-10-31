package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentToLesson;

import java.util.Optional;


public interface StudentToLessonService {

    StudentToLesson saveStudentToLesson(StudentToLesson studentToLesson);

    Optional<StudentToLesson> getStudentToLessonById(Long id);

    Iterable<StudentToLesson> getAllStudentToLessons();

    void deleteStudentToLesson(Long id);

}
