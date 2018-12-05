package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public interface StudentGroupService {

    StudentGroup saveStudentGroup(StudentGroup studentGroup);

    void deleteStudentGroup(Long id);

    List<StudentGroup> getDescriptionsPage(Pageable pageable);

    List<StudentGroup> getDescriptions();

    Optional<StudentGroup> getGroupWithStudentsById(long id);

    List<Lesson> getLessonsById(long id, Date dateFrom, Date dateTo);

    List<User> getStudentsById(long id);

    long count();

    Iterable<StudentGroup> findById(Long number);

    Iterable<StudentGroup> findByCourse(Integer course);
}
