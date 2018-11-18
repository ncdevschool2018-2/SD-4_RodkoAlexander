package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query(value = "FROM Lesson where teacher.id = :teacherId  ")
    Iterable<Lesson> getLessonsByTeacherId(@Param("teacherId") long teacherId);
}
