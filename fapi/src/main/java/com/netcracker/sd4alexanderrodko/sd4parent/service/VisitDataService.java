package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;

import java.util.List;

public interface VisitDataService {
    List<VisitViewModel> getAll();
    VisitViewModel getStudentToLessonById(Long id);
    VisitViewModel saveStudentToLesson(VisitViewModel visitViewModel);
    void deleteStudentToLesson(Long id);
}
