package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User User);

    Optional<User> getUserById(Long id);

    Iterable<User> getAllUsers();

    void deleteUser(Long id);
}
