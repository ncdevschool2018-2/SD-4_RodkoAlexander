package com.netcracker.sd4alexanderrodko.sd4parent.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonViewModel {

    public LessonViewModel() {
    }

    private int id;
    private String timeStart;
    private String timeEnd;
    private TeacherViewModel teacher;
    private String subject;
    private String room;
    private List<GroupViewModel> groups;
    private String lessonType;


}
