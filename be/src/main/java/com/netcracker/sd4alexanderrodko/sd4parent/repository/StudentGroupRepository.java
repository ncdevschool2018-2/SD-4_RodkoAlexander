package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    @Query(value = "SELECT number FROM StudentGroup")
    List<Long> getNumbers();

    @Query(value = "SELECT new StudentGroup (number,course,description) FROM StudentGroup")
    Iterable<StudentGroup> getDescription();

    @Query(value = "SELECT students FROM StudentGroup where number=:number ")
    Iterable<User> getStudents(@Param("number") long number);


}
