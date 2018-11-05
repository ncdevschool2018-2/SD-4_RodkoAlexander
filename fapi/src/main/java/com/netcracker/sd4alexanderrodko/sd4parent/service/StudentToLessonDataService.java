package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentToLessonViewModel;

import java.util.List;

public interface StudentToLessonDataService {
    List<StudentToLessonViewModel> getAll();
    StudentToLessonViewModel getStudentToLessonById(Long id);
    StudentToLessonViewModel saveStudentToLesson(StudentToLessonViewModel studentToLessonViewModel);
    void deleteStudentToLesson(Long id);
}
