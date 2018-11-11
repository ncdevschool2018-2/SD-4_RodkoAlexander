package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Teacher;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.TeacherRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    @Override
    public void deleteTeacher(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveTeacherWithAccount(Teacher teacher) {
            repository.saveTeacherWithAccount(
                    teacher.getAccount().getEmail(),
                    teacher.getAccount().getPassword(),
                    teacher.getAccount().getRole(),
                    teacher.getFirstName(),
                    teacher.getLastName());

    }

}
