package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query(value = "select lesson FROM Lesson lesson where lesson.teacher.id = :teacherId and lesson.timeStart between :dateFrom and  :dateTo and lesson.timeEnd between :dateFrom and  :dateTo")
    List<Lesson> getLessonsByTeacherIdByOrderByTimeStart(@Param("teacherId") long teacherId, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

    @Query(value = "select lesson FROM Lesson lesson join lesson.groups lessonGroups where :stgroup in (lessonGroups) and lesson.timeStart between :dateFrom and  :dateTo and lesson.timeEnd between :dateFrom and  :dateTo")
    List<Lesson> getLessonsByGroupIdByOrderByTimeStart(@Param("stgroup") StudentGroup group, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

    @Modifying
    @Transactional
    @Query(value = "delete  FROM Lesson  where teacher.id = :id")
    void deleteTeachersLessons(@Param("id") Long id);

    @Query(value = "select count(lesson) from Lesson lesson where lesson.teacher.id = :teacher and ((lesson.timeStart > :timeStart and lesson.timeStart< :timeEnd) or (lesson.timeEnd > :timeStart and lesson.timeEnd< :timeEnd))")
    Long checkTeacher(@Param("teacher") long teacher,
                      @Param("timeStart") Timestamp start,
                      @Param("timeEnd") Timestamp end);


    @Query(value = "select count(lesson) from Lesson lesson JOIN lesson.groups grs where grs in :groups and ((lesson.timeStart > :timeStart and lesson.timeStart< :timeEnd) or (lesson.timeEnd > :timeStart and lesson.timeEnd< :timeEnd))")
    Long checkGroups(@Param("timeStart") Timestamp start,
                     @Param("timeEnd") Timestamp end,
                     @Param("groups") Collection<StudentGroup> groups);

}
