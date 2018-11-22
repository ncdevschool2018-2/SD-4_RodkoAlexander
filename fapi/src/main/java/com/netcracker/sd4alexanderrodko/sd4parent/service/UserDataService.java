package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.RoleViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserDataService extends UserDetailsService {

    AccountViewModel getEmployerById(Long id);

    AccountViewModel saveEmployer(AccountViewModel employer);

    AccountViewModel saveStudent(StudentViewModel student);

    void deleteStudent(long groupId, long studentId);

    void deleteEmployer(long employerId);

    List<AccountViewModel> getEmployers();

    List<UserViewModel> getTeachers();

    List<UserViewModel> getStudentsFromGroup(long groupId);

    List<RoleViewModel> getRoles();

}
