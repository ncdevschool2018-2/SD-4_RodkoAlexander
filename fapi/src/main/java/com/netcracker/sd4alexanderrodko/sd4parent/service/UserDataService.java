package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;

import java.util.Optional;

public interface UserDataService {
    UserViewModel saveUser(UserViewModel User);

    Optional<UserViewModel> getUserById(Long id);

    Iterable<UserViewModel> getAllUsers();

    void deleteUser(Long id);
}
