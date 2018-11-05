package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupToLessonViewModel;

import java.util.List;

public interface StudentGroupToLessonDataService {
    List<StudentGroupToLessonViewModel> getAll();
    StudentGroupToLessonViewModel getStudentGroupToLessonById(Long id);
    StudentGroupToLessonViewModel saveStudentGroupToLesson(StudentGroupToLessonViewModel studentGroupToLessonViewModel);
    void deleteStudentGroupToLesson(Long id);
}
