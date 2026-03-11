package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.user.UserAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserResponseDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserUpdatingRequestDto;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;

public interface IUserService {
	
	List<UserResponseDto> getAllUsers();
	UserResponseDto getUserByEmail(String email)throws UserNotFoundException;
	UserResponseDto addUser(UserAddingRequestDto userDto)throws ServiceNotAllowedException;
	UserResponseDto updateUser(UserUpdatingRequestDto userDto,int userId)throws UserNotFoundException;
	String deactivateUserByEmail(String email)throws UserNotFoundException;
	String deactivateUserById(int id)throws UserNotFoundException;
	String activateUserByEmail(String email)throws UserNotFoundException;
	String activateUserById(int id)throws UserNotFoundException;

}
