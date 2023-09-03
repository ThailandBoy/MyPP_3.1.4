package ru.chuldum.MyPP_314.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.chuldum.MyPP_314.entities.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = ?1")
    User findByUsername(String username);

    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.roles ORDER BY u.id")
    public List<User> getAll();


}
