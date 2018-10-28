package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Group;

import java.util.Optional;

public interface GroupService {
    Group saveStudentGroup(Group group);

    Optional<Group> getStudentGroupById(Long id);

    Iterable<Group> getAllStudentGroups();

    void deleteStudentGroup(Long id);
}
