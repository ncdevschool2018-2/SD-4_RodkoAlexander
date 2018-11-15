package com.netcracker.sd4alexanderrodko.sd4parent.repository;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "select user from User user where user.role='Teacher'")
    Iterable<User> getTeachers();

    @Query(value = "select user from User user where user.role='Administrator'")
    Iterable<User> getAdministrators();

    @Query(value = "select user from User user where user.role='Student'")
    Iterable<User> getStudents();
}
