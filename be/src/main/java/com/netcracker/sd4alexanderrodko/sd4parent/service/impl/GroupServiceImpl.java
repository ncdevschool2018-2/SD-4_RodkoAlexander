package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Group;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.GroupRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class GroupServiceImpl implements GroupService {

    private GroupRepository repository;

    @Autowired
    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public Group saveStudentGroup(Group group) {
        return repository.save(group);
    }

    @Override
    public Optional<Group> getStudentGroupById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Group> getAllStudentGroups() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentGroup(Long id) {
        repository.deleteById(id);
    }

}
