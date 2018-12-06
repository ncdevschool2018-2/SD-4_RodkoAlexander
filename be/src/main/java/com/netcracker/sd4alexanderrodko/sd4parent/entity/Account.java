package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "accounts", schema = "backend")
public class Account {

    private long id;
    private String email;
    private String password;
    private Role role;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(unique = true,name = "email", nullable = false, length = 256)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 256)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
