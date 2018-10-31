package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroupToLesson;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.StudentGroupToLessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupToLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class StudentGroupToLessonServiceImpl implements StudentGroupToLessonService {

    private StudentGroupToLessonRepository repository;

    @Autowired
    public StudentGroupToLessonServiceImpl(StudentGroupToLessonRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentGroupToLesson saveStudentGroupToLesson(StudentGroupToLesson studentGroupToLesson) {
        return repository.save(studentGroupToLesson);
    }

    @Override
    public Optional<StudentGroupToLesson> getStudentGroupToLessonById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<StudentGroupToLesson> getAllStudentGroupToLessons() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentGroupToLesson(Long id) {
        repository.deleteById(id);
    }
}
