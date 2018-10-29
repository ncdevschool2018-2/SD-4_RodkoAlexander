package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "students_visits")
public class Visit implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean isVisit;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("lessonId")
    private Lesson lesson;

    public Visit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVisit() {
        return isVisit;
    }

    public void setVisit(boolean visit) {
        isVisit = visit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return id == visit.id &&
                isVisit == visit.isVisit &&
                Objects.equals(student, visit.student) &&
                Objects.equals(lesson, visit.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isVisit, student, lesson);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("id=").append(id);
        sb.append(", isVisit=").append(isVisit);
        sb.append(", student=").append(student);
        sb.append(", lesson=").append(lesson);
        sb.append('}');
        return sb.toString();
    }
}
