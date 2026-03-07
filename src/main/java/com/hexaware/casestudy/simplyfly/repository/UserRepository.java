package com.hexaware.casestudy.simplyfly.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);
	void deleteByEmail(String email);
}
