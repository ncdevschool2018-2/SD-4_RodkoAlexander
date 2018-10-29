package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "student_groups")
public class StudentGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    private String description;

    private String course;



    @ManyToMany
    @JsonManagedReference
    private List<Lesson> lessons;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    @JsonManagedReference
    private List<Student> students;

    public StudentGroup() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup studentGroup = (StudentGroup) o;
        return number == studentGroup.number &&
                Objects.equals(course, studentGroup.course) &&
                Objects.equals(description, studentGroup.description) &&
                Objects.equals(lessons, studentGroup.lessons) &&
                Objects.equals(students, studentGroup.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, description, course, lessons, students);
    }

}


