package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SubjectViewModel {

    private long id;
    @NotBlank
    @Size(min = 2)
    private String abbreviation;
    @Size(max = 256)
    @NotBlank
    private String fullName;


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SubjectViewModel() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
