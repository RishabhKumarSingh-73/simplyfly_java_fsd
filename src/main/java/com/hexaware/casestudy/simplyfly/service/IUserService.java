package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.User;

public interface IUserService {
	
	List<User> getAllUsers();
	User getUserByEmail(String email);
	int addUser(User user);
	int updateUser(User user);
	int deleteUserByEmail(String email);
	int deleteUserById(int id);

}
