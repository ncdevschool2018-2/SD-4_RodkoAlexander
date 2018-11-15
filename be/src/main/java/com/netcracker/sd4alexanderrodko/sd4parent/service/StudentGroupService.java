package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;

import java.util.List;
import java.util.Optional;


public interface StudentGroupService {

    StudentGroup saveStudentGroup(StudentGroup studentGroup);

    Optional<StudentGroup> getStudentGroupById(Long id);

    Iterable<StudentGroup> getAllStudentGroups();

    void deleteStudentGroup(Long id);

    List<Long> getNumbers();

    Iterable<StudentGroup> getDescriptions();

    Iterable<User> getStudents(long groupNumber);

}
