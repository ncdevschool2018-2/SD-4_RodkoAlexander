package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;

import java.util.Optional;


public interface StudentService {

    Student saveStudent(Student student);

    Optional<Student> getStudentById(Long id);

    Iterable<Student> getAllStudents();

    void deleteStudent(Long id);

    void saveStudentWithAccount(Student student);

}
