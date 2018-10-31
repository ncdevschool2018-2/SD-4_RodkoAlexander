package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "accounts", schema = "backend", catalog = "")
public class Account {
    private long id;
    private String email;
    private String password;
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
    @Column(name = "email", nullable = false, length = 256)
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
    @Column(name = "role", nullable = true, length = 256)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(email, account.email) &&
                Objects.equals(password, account.password) &&
                Objects.equals(role, account.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }
}
