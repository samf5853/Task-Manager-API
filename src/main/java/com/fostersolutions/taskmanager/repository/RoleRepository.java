package com.fostersolutions.taskmanager.repository;

import com.fostersolutions.taskmanager.models.ERole;
import com.fostersolutions.taskmanager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
