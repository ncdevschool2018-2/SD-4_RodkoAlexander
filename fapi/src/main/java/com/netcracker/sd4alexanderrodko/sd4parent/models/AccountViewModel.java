package com.netcracker.sd4alexanderrodko.sd4parent.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountViewModel {

    private long id;
    private String email;
    private String password;
    private String role;

    public AccountViewModel() {
    }

    public AccountViewModel(long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
