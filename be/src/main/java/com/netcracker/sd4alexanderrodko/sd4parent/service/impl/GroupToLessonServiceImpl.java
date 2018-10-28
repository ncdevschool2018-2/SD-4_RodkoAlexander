package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.GroupToLesson;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.GroupToLessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.GroupToLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class GroupToLessonServiceImpl implements GroupToLessonService {

    private GroupToLessonRepository repository;

    @Autowired
    public GroupToLessonServiceImpl(GroupToLessonRepository repository) {
        this.repository = repository;
    }

    @Override
    public GroupToLesson saveGroupToLesson(GroupToLesson groupToLesson) {
        return repository.save(groupToLesson);
    }

    @Override
    public Optional<GroupToLesson> getGroupToLessonById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<GroupToLesson> getAllGroupToLessons() {
        return repository.findAll();
    }

    @Override
    public void deleteGroupToLesson(Long id) {
        repository.deleteById(id);
    }

}
