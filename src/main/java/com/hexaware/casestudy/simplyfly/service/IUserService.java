package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;

public interface IUserService {
	
	List<User> getAllUsers();
	User getUserByEmail(String email)throws UserNotFoundException;
	User addUser(User user)throws ServiceNotAllowedException;
	User updateUser(User user)throws UserNotFoundException;
	String deleteUserByEmail(String email)throws UserNotFoundException;
	String deleteUserById(int id)throws UserNotFoundException;

}
