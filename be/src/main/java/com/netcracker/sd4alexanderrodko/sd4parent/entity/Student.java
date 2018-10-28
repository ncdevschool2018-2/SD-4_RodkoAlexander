package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="account_id")
    private Account account;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private StudentGroup group;

    @OneToMany(mappedBy="student")
    private List<StudentVisit> visits;

    @Column(name="name", length = 255, nullable = false)
    private String name;


    @Column(name="surname", length = 255, nullable = false)
    private String surame;

    public Student() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", group=").append(group);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surame='").append(surame).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(account, student.account) &&
                Objects.equals(group, student.group) &&
                Objects.equals(name, student.name) &&
                Objects.equals(surame, student.surame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, group, name, surame);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurame() {
        return surame;
    }

    public void setSurame(String surame) {
        this.surame = surame;
    }
}
