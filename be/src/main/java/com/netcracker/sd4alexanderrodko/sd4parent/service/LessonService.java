package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;


public interface LessonService {

    Lesson saveLesson(Lesson lesson);

    Iterable<Lesson> getAllLessons();

    void deleteLesson(Long id);

    Iterable<Lesson> getLessonsByTeacher(long teacherId);
}
