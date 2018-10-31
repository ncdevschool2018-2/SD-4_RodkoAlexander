package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentToLesson;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.StudentToLessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentToLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class StudentToLessonServiceImpl implements StudentToLessonService {
    private StudentToLessonRepository repository;

    @Autowired
    public StudentToLessonServiceImpl(StudentToLessonRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentToLesson saveStudentToLesson(StudentToLesson studentToLesson) {
        return repository.save(studentToLesson);
    }

    @Override
    public Optional<StudentToLesson> getStudentToLessonById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<StudentToLesson> getAllStudentToLessons() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentToLesson(Long id) {
        repository.deleteById(id);
    }
}
