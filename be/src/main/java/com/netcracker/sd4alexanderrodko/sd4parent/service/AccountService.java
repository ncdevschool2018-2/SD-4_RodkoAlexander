package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.Role;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account saveEmployer(Account employer);

    Optional<Account> getEmployerById(Long id);

    void deleteEmployer(Long id);

    Optional<Account> login(String email);

    long count();

    List<Account> getAllByPage(Pageable pageable);

    List<Account> getAll();

    List<Account> findByLastName(String lastName);

    List<User> getFindTeacherByLastName(String lastName);

    List<Account> findByLastNameAndRole(String lastName, long roleId);

    Iterable<Role> getRoles();

}
