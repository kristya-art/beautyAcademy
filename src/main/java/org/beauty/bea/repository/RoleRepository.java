package org.beauty.bea.repository;

import org.beauty.bea.model.Role;
import org.beauty.bea.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByType(RoleType roleType);
}
