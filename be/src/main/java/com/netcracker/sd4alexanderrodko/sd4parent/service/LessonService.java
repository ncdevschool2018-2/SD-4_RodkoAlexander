package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;


public interface LessonService {

    Lesson saveLesson(Lesson lesson);

    List<Lesson> getLessonsByPage(Pageable pageable);

    void deleteLesson(Long id);

    List<Lesson> getLessonsByTeacher(long teacherId, Date dateFrom, Date dateTo);

    long count();

    Iterable<Lesson> getAll();

    void deleteTeachersLessons(Long teacherId);
}
