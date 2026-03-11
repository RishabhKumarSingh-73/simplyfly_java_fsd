package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.user.UserAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserResponseDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserUpdatingRequestDto;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.mapper.UserMapper;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements IUserService {
	
	@Autowired
	private UserRepository repository;

	// will take care access in authorization

	@Override
	public List<UserResponseDto> getAllUsers() {
		
		return repository.findAll().stream().map(user->{
			return UserMapper.entityToUserResponseDto(user);
		}).toList();
		
	}

	@Override
	public UserResponseDto getUserByEmail(String email) throws UserNotFoundException{
		
		User user = repository.findByEmail(email).orElseThrow(()->new UserNotFoundException("user record not found"));
		
		return UserMapper.entityToUserResponseDto(user);
		
	}

	@Override
	public UserResponseDto addUser(UserAddingRequestDto userDto) throws ServiceNotAllowedException{
		
		if(userDto.getRole() == Role.ADMIN)throw new ServiceNotAllowedException("registering as admin not allowed");

		User user = UserMapper.userAddingRequestDtoToEntity(userDto);

		return UserMapper.entityToUserResponseDto(repository.save(user));
	
	}

	@Override
	public UserResponseDto updateUser(UserUpdatingRequestDto userDto,int userId) throws UserNotFoundException{

		
		User user = repository.findById(userId).orElseThrow(()-> new UserNotFoundException("user record not found"));

		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPasswordHash(userDto.getPasswordHash());
		
		return UserMapper.entityToUserResponseDto(repository.save(user));
		
	}

	@Override
	public String deactivateUserByEmail(String email) throws UserNotFoundException{

		User user = repository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("user record not found"));

		user.setActive(false);
		
		repository.save(user);
		
		return "user record deactivated successfully";
	
	}

	@Override
	public String deactivateUserById(int id) throws UserNotFoundException{

		User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException("user record not found"));
		
		user.setActive(false);
		
		repository.save(user);
		
		return "user record deactivated successfully";
	
	}

	@Override
	public String activateUserByEmail(String email) throws UserNotFoundException {

		User user = repository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("user record not found"));

		user.setActive(true);
		
		repository.save(user);
		
		return "user record activated successfully";
	}

	@Override
	public String activateUserById(int id) throws UserNotFoundException {
		User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException("user record not found"));
		
		user.setActive(true);
		
		repository.save(user);
		
		return "user record activated successfully";
	}

}
