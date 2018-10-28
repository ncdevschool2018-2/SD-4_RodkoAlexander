package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.GroupToLesson;

import java.util.Optional;

public interface GroupToLessonService {
    GroupToLesson saveGroupToLesson(GroupToLesson groupToLesson);

    Optional<GroupToLesson> getGroupToLessonById(Long id);

    Iterable<GroupToLesson> getAllGroupToLessons();

    void deleteGroupToLesson(Long id);
}
