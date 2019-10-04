package com.zapacademy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zapacademy.entity.User;


public interface UserRepository extends JpaRepository<User, String>{
	 public Optional<User> findByEmail(String email);
}
