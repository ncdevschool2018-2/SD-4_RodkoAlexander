package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("from Visit visit where visit.lesson.id = :lessonId and visit.student in :groupId")
    List<Visit> getVisitByGroupIdAndLessonId(@Param("groupId") List<User> groupId, @ Param("lessonId") long lessonId);
}
