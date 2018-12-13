package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleViewModel {

    @NotNull
    private Long id;
    @NotBlank
    @Size(min = 3)
    private String name;

    public RoleViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
