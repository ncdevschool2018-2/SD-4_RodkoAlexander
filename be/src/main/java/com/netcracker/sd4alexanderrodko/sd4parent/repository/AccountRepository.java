package com.netcracker.sd4alexanderrodko.sd4parent.repository;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select account.user from Account account where account.role='Teacher'")
    Iterable<User> getTeachers();

    @Query(value = "select acc from Account acc where acc.role='Administrator' or acc.role='Teacher'")
    Iterable<Account> getEmployers();
}

