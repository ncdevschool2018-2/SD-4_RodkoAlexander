package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Teacher;

import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);

    Optional<Teacher> getTeacherById(Long id);

    Iterable<Teacher> getAllTeachers();

    void deleteTeacher(Long id);

}
