package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {


    @Query(value = "FROM StudentGroup ")
    Iterable<StudentGroup> getDescription();

    @Query(value = "FROM StudentGroup WHERE id = :number")
    Optional<StudentGroup> getGroupWithStudentsById(@Param("number") long id);

    @Query(value = "SELECT sg.lessons from StudentGroup sg  where sg.id = :number")
    Iterable<Lesson> getLessonsByGroupId(@Param("number") long id);


    @Query(value = "SELECT sg.users from StudentGroup  sg where sg.id = :number")
    Iterable<User> getStudentsByGroupId(@Param("number") long id);
}
