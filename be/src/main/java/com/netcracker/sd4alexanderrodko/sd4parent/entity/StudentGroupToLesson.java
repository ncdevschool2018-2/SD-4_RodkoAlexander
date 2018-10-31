package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "student_groups_to_lessons", schema = "backend", catalog = "")
public class StudentGroupToLesson {
    private long id;
    private StudentGroup studentGroupsByGroupNumber;
    private Lesson lessonsByLessonId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroupToLesson that = (StudentGroupToLesson) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "group_number", referencedColumnName = "number")
    public StudentGroup getStudentGroupsByGroupNumber() {
        return studentGroupsByGroupNumber;
    }

    public void setStudentGroupsByGroupNumber(StudentGroup studentGroupsByGroupNumber) {
        this.studentGroupsByGroupNumber = studentGroupsByGroupNumber;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    public Lesson getLessonsByLessonId() {
        return lessonsByLessonId;
    }

    public void setLessonsByLessonId(Lesson lessonsByLessonId) {
        this.lessonsByLessonId = lessonsByLessonId;
    }
}
