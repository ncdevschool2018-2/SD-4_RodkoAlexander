package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class AccountViewModel {

    private long id;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min=6)
    private String password;
    @NotNull
    @Valid
    private RoleViewModel role;
    @NotNull
    @Valid
    private UserViewModel user;

    public AccountViewModel() {
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

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public RoleViewModel getRole() {
        return role;
    }

    public void setRole(RoleViewModel role) {
        this.role = role;
    }

}
