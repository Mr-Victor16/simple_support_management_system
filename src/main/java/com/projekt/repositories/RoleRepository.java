package com.projekt.repositories;

import com.projekt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByIdAndUsers_Username(Integer id, String username);

}
