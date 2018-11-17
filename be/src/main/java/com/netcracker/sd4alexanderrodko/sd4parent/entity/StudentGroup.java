package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "university_groups", schema = "backend", catalog = "")
public class StudentGroup {
    private Long id;
    private Long course;
    private String description;
    private Collection<User> students;
    private Collection<Lesson> lessons;

    public StudentGroup() {
    }

    public StudentGroup(Long id, Long course, String description) {
        this.id = id;
        this.course = course;
        this.description = description;
    }
    public StudentGroup(Long id, Long course, String description,Collection<User> students) {
        this.id = id;
        this.course = course;
        this.description = description;
        this.students = students;
    }
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return Objects.equals(id, that.id) &&
                Objects.equals(course, that.course) &&
                Objects.equals(description, that.description) &&
                Objects.equals(students, that.students) &&
                Objects.equals(lessons, that.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, description);
    }
}
