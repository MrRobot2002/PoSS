package com.vu.localhost.poss.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.role.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}