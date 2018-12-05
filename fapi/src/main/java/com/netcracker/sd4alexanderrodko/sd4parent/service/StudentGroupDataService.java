package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;

import java.util.List;

public interface StudentGroupDataService {

    StudentGroupViewModel saveStudentGroup(StudentGroupViewModel studentGroupViewModel);

    void deleteStudentGroup(Long id);

    List<StudentGroupViewModel> getDescriptions(Integer page, Integer size);

    List<StudentGroupViewModel> findByGroupNumber(String groupNumber);

    Long count();

    List<StudentGroupViewModel> findGroupsByCourse(Integer course);
}
