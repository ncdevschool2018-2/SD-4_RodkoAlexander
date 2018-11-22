package com.netcracker.sd4alexanderrodko.sd4parent.repository;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select account.user from Account account where account.role.name='Teacher'")
    Iterable<User> getTeachers();

    @Query(value = "select acc from Account acc where acc.role.name='Administrator' or acc.role.name='Teacher'")
    Iterable<Account> getEmployers();

    @Query(value = "from Account acc where acc.email=:email")
    Optional<Account> isExists(@Param("email") String email);


}

