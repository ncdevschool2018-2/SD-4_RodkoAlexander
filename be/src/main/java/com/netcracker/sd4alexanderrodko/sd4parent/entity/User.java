package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;


@Entity
@Table(name = "users", schema = "backend", catalog = "")
public class User {



    private long id;
    private String firstName;
    private String lastName;
    private String role;

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
    @Column(name = "first_name", nullable = true, length = 256)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 256)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 256)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
