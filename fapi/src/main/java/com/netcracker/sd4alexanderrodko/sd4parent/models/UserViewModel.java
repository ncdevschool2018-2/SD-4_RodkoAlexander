package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserViewModel {

    private long id;
    @NotBlank
    @Size(min = 3)
    private String firstName;
    @Size(min = 3)
    @NotBlank
    private String lastName;

    public UserViewModel() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
