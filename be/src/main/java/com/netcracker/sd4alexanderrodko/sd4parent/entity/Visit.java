package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "visits", schema = "backend", catalog = "")
public class Visit {
    private long id;
    private Byte visit;
    private Lesson lesson;
    private Student student;

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
        Visit that = (Visit) o;
        return id == that.id &&
                Objects.equals(visit, that.visit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visit);
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @ManyToOne
    @JoinColumn(name = "student_number", referencedColumnName = "number")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
