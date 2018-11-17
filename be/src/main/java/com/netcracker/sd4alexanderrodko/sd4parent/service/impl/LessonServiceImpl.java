package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.LessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class LessonServiceImpl implements LessonService {

    private LessonRepository repository;

    @Autowired
    public LessonServiceImpl(LessonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    @Override
    public Iterable<Lesson> getAllLessons() {
        return repository.findAll();
    }

    @Override
    public void deleteLesson(Long id) {
        repository.deleteById(id);
    }


    @Override
    public Iterable<Lesson> getLessonsByTeacher(long teacherId) {
        return repository.getLessonsByTeacherId(teacherId);
    }


}
