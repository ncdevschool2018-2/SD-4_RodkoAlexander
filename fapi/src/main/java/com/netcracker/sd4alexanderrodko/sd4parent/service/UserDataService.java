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

    AccountViewModel transferStudent(Long oldGroup, Long newGroup, Long id);

    void deleteStudent(long groupId, long studentId);

    void deleteEmployer(long employerId);

    List<AccountViewModel> getAll(Integer page, Integer size);

    List<AccountViewModel> getAllByLastName(String lastName);

    List<AccountViewModel> getAllByLastNameAndRole(String lastName, String roleId);

    List<UserViewModel> getTeachersByLastName(String lastName);

    List<UserViewModel> getStudentsFromGroup(long groupId);

    List<RoleViewModel> getRoles();

    Long count();
}
