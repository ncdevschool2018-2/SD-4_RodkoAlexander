package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;

import java.util.List;

public interface ScheduleDataService {

    List<LessonViewModel> getAll();

    LessonViewModel saveLesson(LessonViewModel lessonViewModel);

    void deleteLesson(Long id);

    List<LessonViewModel> getLessonsByTeacherId(long teacherId);

    List<LessonViewModel> getLessonsByGroupId(long groupId);
}
