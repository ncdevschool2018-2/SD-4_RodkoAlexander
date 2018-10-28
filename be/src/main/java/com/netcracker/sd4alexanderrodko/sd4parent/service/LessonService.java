package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;

import java.util.Optional;

public interface LessonService {
    Lesson saveLesson(Lesson lesson);

    Optional<Lesson> getLessonById(Long id);

    Iterable<Lesson> getAllLessons();

    void deleteLesson(Long id);
}
