package com.zapacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zapacademy.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
