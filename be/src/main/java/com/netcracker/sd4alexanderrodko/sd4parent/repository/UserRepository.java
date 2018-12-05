package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
