package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.RoleViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserDataService extends UserDetailsService {

    AccountViewModel saveEmployer(AccountViewModel employer);

    AccountViewModel saveStudent(StudentViewModel student);

    void transferStudent(Long newGroup, Long id);

    void deleteStudent(Long studentId);

    void deleteEmployer(Long employerId);

    List<AccountViewModel> getAll(Integer page, Integer size);

    List<AccountViewModel> getAccountsByLastNameAndRole(String lastName, Long roleId);

    List<UserViewModel> getUsersByLastNameAndRole(String lastName,Long roleId);

    List<UserViewModel> getStudentsFromGroup(Long groupId);

    List<RoleViewModel> getRoles();

    Long count();
}
