package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface StudentGroupService {

    StudentGroup saveStudentGroup(StudentGroup studentGroup);

    void deleteStudentGroup(Long id);

    Iterable<StudentGroup> getDescriptions();

    Optional<StudentGroup> getGroupWithStudentsByid(long id);

    Iterable<Lesson> getLessonsById(long id);

    Iterable<User> getStudentsById(long id);
}
