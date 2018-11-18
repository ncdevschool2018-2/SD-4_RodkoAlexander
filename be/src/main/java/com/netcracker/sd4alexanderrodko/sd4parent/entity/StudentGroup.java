package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "student_groups", schema = "backend", catalog = "")
public class StudentGroup {
    private long id;
    private long course;
    private String description;
    private Collection<User> users;
    private Collection<Lesson> lessons;

    public StudentGroup() {
    }

    public StudentGroup(long id, long course, String description) {
        this.id = id;
        this.course = course;
        this.description = description;
    }

    public StudentGroup(long id, long course, String description, Collection<User> users) {
        this.id = id;
        this.course = course;
        this.description = description;
        this.users = users;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "groups")
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }

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
    @Column(name = "course")
    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    @Basic
    @Column(name = "description", length = 256)
    public String getDescription() {
        return description;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
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
                Objects.equals(users, that.users) &&
                Objects.equals(lessons, that.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, description);
    }
}
