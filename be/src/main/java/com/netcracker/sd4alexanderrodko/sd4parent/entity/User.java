package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "users", schema = "backend", catalog = "")
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String role;
    private Account account;
    private long groupNumber;

    @Basic
    @Column(name = "groupNumber", nullable = true)
    public long getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Id
    @Column(name="id")
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


    /*@JsonIgnore*/
    @JsonBackReference
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
