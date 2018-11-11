package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
   /* @Query(value = Queries.SELECT_ID_FROM_ACCOUNT_BY_EMAIL)
    Optional<Long> getIdByEmail(String email);*/

    @Query(value = "SELECT id from Account ac where ac.email = :email")
    Optional<Long> getIdByEmail(@Param("email") String email);

   /* @Query(value = "INSERT into ",nativeQuery = true)
    Optional<Long> insert(String r,byte s);
*/
}
