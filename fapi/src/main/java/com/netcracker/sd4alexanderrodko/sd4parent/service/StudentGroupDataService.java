package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;

import java.util.List;

public interface StudentGroupDataService {
    List<StudentGroupViewModel> getAll();
    StudentGroupViewModel getStudentGroupById(Long id);
    StudentGroupViewModel saveStudentGroup(StudentGroupViewModel studentGroupViewModel);
    void deleteStudentGroup(Long id);
    List<Long> getNumbers();
}
