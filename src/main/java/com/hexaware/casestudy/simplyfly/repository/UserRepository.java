package com.hexaware.casestudy.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.casestudy.simplyfly.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
