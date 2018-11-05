package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;

import java.util.List;

public interface LessonDataService {
    List<LessonViewModel> getAll();
    LessonViewModel getLessonById(Long id);
    LessonViewModel saveLesson(LessonViewModel lessonViewModel);
    void deleteLesson(Long id);
}
