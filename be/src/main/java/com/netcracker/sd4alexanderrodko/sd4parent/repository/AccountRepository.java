package com.netcracker.sd4alexanderrodko.sd4parent.repository;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "from Account acc where acc.user.lastName = :lastName")
    List<Account> findAccountsByUserLastName(@Param("lastName") String lastName);

    @Query(value = "from Account acc where acc.user.lastName = :lastName and acc.role.id = :roleId")
    List<Account> findAccountsByUserLastNameAndRole(@Param("lastName") String lastName, @Param("roleId") long roleId);

    @Query(value = "from Account acc where acc.email=:email")
    Optional<Account> isExists(@Param("email") String email);

    @Query(value = "select account.user from Account account where account.role.id=2 and account.user.lastName like :lastName%")
    List<User> getTeachersByLastName(@Param("lastName") String lastName);

}

