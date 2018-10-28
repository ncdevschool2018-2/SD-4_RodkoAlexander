package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class StudentGroup {


    @Id
    private long id;

    private String description;
    private byte course;


    @ManyToMany
    @JoinTable(
            name="lesson",
            joinColumns=@JoinColumn(name="group_id"),
            inverseJoinColumns=@JoinColumn(name="lesson_id"))
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentGroup{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", course=").append(course);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return id == that.id &&
                course == that.course &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, course);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getCourse() {
        return course;
    }

    public void setCourse(byte course) {
        this.course = course;
    }

    public StudentGroup() {
    }
}
