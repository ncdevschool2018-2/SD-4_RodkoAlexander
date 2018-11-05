package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.TeacherViewModel;

import java.util.List;

public interface TeacherDataService {
    List<TeacherViewModel> getAll();
    TeacherViewModel getTeacherById(Long id);
    TeacherViewModel saveTeacher(TeacherViewModel teacherViewModel);
    void deleteTeacher(Long id);
}
