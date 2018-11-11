package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;

import java.util.List;

public interface StudentDataService {

    List<StudentViewModel> getAll();
    StudentViewModel getStudentById(Long id);
    StudentViewModel saveStudent(StudentViewModel studentViewModel);
    StudentViewModel saveStudentWithAccount(StudentViewModel studentViewModel);
    void deleteStudent(Long id);
}
