package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_to_lesson", schema = "backend", catalog = "")
public class StudentToLesson {
    private int entryId;
    private Byte visit;
    private Student studentByStudentId;
    private Lesson lessonByLessonId;

    @Id
    @Column(name = "entry_id", nullable = false)
    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
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
        return entryId == that.entryId &&
                Objects.equals(visit, that.visit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryId, visit);
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id", nullable = false)
    public Lesson getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(Lesson lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }
}
