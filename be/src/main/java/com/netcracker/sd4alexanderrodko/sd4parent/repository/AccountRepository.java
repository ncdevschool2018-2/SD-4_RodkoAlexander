package com.netcracker.sd4alexanderrodko.sd4parent.repository;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select account from Account account where role='Teacher'")
    Iterable<Account> getTeachers();

    @Query(value = "select account from Account account where role='Administrator'")
    Iterable<Account> getAdministrators();

    @Query(value = "select account from Account account where role='Student'")
    Iterable<Account> getStudents();

    @Query(value = "select account from Account account where role='Administrator' or role='Teacher'")
    Iterable<Account> getEmployers();
}

