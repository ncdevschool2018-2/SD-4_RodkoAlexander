package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    @Query(value = "select new StudentGroup (id,course,description) FROM StudentGroup")
    List<StudentGroup> getDescriptionsPage(Pageable pageRequest);

    @Query(value = "select new StudentGroup (id,course,description) FROM StudentGroup ")
    List<StudentGroup> getDescriptions();

    @Query(value = "select new StudentGroup (id,course,description) FROM StudentGroup where str(id) like :number%")
    List<StudentGroup> getGroupByNumber(@Param("number") String id);

    @Query(value = "FROM StudentGroup WHERE id = :number")
    Optional<StudentGroup> getGroupWithStudentsById(@Param("number") long id);

    @Query(value = "SELECT sg.users from StudentGroup  sg where sg.id = :number")
    List<User> getStudentsFromGroupById(@Param("number") long id);

    @Query(value = "select new StudentGroup (id,course,description) FROM StudentGroup WHERE course = :course")
    Iterable<StudentGroup> findByCourse(@Param("course") Integer course);
}
