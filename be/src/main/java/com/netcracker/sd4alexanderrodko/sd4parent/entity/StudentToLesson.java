package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "students_to_lessons", schema = "backend", catalog = "")
public class StudentToLesson {
    private long id;
    private Byte visit;
    private Lesson lessonsByLessonId;
    private Student studentsByStudentNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "visit", nullable = true)
    public Byte getVisit() {
        return visit;
    }

    public void setVisit(Byte visit) {
        this.visit = visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentToLesson that = (StudentToLesson) o;
        return id == that.id &&
                Objects.equals(visit, that.visit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visit);
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    public Lesson getLessonsByLessonId() {
        return lessonsByLessonId;
    }

    public void setLessonsByLessonId(Lesson lessonsByLessonId) {
        this.lessonsByLessonId = lessonsByLessonId;
    }

    @ManyToOne
    @JoinColumn(name = "student_number", referencedColumnName = "number")
    public Student getStudentsByStudentNumber() {
        return studentsByStudentNumber;
    }

    public void setStudentsByStudentNumber(Student studentsByStudentNumber) {
        this.studentsByStudentNumber = studentsByStudentNumber;
    }
}
