package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.LessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;


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
    public List<Lesson> getLessonsByPage(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public void deleteLesson(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Lesson> getLessonsByTeacher(long teacherId, Date dateFrom, Date dateTo) {
        return repository.getLessonsByTeacherIdByOrderByTimeStart(teacherId, dateFrom, dateTo);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Iterable<Lesson> getAll() {
        return repository.findAll();
    }


}
