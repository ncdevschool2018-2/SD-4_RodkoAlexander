package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.StudentGroupRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
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
    public Optional<StudentGroup> getStudentGroupById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<StudentGroup> getAllStudentGroups() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentGroup(Long id) {
        repository.deleteById(id);
    }



}
