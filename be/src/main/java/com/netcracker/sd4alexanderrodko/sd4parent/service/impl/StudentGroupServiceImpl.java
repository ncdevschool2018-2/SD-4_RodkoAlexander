package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.StudentGroupRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class StudentGroupServiceImpl implements StudentGroupService {

    private StudentGroupRepository repository;

    @Autowired
    public StudentGroupServiceImpl(StudentGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentGroup saveStudentGroup(StudentGroup studentGroup) {
        return repository.save(studentGroup);
    }

    @Override
    public void deleteStudentGroup(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<StudentGroup> getDescriptions() {
        return repository.getDescription();
    }

    @Override
    public Optional<StudentGroup> getGroupWithStudentsByid(long id) {
        return repository.getGroupWithStudentsById(id);
    }

    @Override
    public Iterable<Lesson> getLessonsById(long id) {
        return repository.getLessonsByGroupId(id);
    }

    @Override
    public Iterable<User> getStudentsById(long id) {
        return repository.getStudentsByGroupId(id);
    }
}
