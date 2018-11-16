package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "university_groups", schema = "backend", catalog = "")
public class StudentGroup {
    private Long number;
    private Long course;
    private String description;
    private Collection<User> students;
    private Collection<Lesson> lessons;

    public StudentGroup() {
    }

    public StudentGroup(long number, Collection<User> students) {
        this.students = students;
        this.number = number;
    }

    public StudentGroup(Collection<User> students) {
        this.students = students;
    }

    public StudentGroup(Long number, Long course, String description) {
        this.number = number;
        this.course = course;
        this.description = description;
    }


    @JsonIgnore
    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Basic
    @Column(name = "course", nullable = true)
    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 256)
    public String getDescription() {
        return description;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<User> getStudents() {
        return students;
    }

    public void setStudents(Collection<User> students) {
        this.students = students;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(course, that.course) &&
                Objects.equals(description, that.description) &&
                Objects.equals(students, that.students) &&
                Objects.equals(lessons, that.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, course, description);
    }
}
