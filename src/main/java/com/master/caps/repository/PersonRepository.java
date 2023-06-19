package com.master.caps.repository;

import com.master.caps.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.roleType = :roleType and p.username = :username AND p.password = :password")
    Person findPersonByNameAndPwd(@Param("roleType") int roleType, @Param("username") String username, @Param("password") String password);
}
