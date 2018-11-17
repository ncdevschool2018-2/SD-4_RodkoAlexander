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


    @Query(value = "SELECT new StudentGroup (id,course,description) FROM StudentGroup")
    Iterable<StudentGroup> getDescription();

    @Query(value = "SELECT new StudentGroup (id,course,description,students) FROM StudentGroup where id=:groupId")
    Optional<StudentGroup> getGroupWithStudentsById(@Param("groupId") long groupId);

    @Query(value = "SELECT sg.lessons from StudentGroup sg where sg.id = :groupId")
    Iterable<Lesson> getLessonsByGroupId(@Param("groupId") long groupId);


    @Query(value = "SELECT sg.students from StudentGroup sg where sg.id = :groupId")
    Iterable<User> getStudentsByGroupId(@Param("groupId") long groupId);
}
