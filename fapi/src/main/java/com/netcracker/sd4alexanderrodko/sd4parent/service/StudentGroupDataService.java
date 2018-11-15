package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;

import java.util.List;

public interface StudentGroupDataService {
    List<StudentGroupViewModel> getAll();
    StudentGroupViewModel getStudentGroupById(Long id);
    StudentGroupViewModel saveStudentGroup(StudentGroupViewModel studentGroupViewModel);
    void deleteStudentGroup(Long id);
    List<Long> getNumbers();
    List<StudentGroupViewModel> getDescriptions();
    List<UserViewModel> getStudents(long groupNumber);
}
