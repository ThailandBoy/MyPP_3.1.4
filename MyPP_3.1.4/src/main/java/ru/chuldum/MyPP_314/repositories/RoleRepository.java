package ru.chuldum.MyPP_314.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chuldum.MyPP_314.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
