package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements IUserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUsers() {
		
		return repository.findAll();
		
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException{
		
		User user = repository.findByEmail(email).orElseThrow(()->new UserNotFoundException("user record not found"));
		
		return user;
		
	}

	@Override
	public User addUser(User user) throws ServiceNotAllowedException{
		
		if(user.getRole() == Role.ADMIN)throw new ServiceNotAllowedException("registering as admin not allowed");

		return repository.save(user);
	
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException{

		repository.findById(user.getId()).orElseThrow(()-> new UserNotFoundException("user record not found"));
		
		return repository.save(user);
		
	}

	@Override
	public String deleteUserByEmail(String email) throws UserNotFoundException{

		User user = repository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("user record not found"));
		
		repository.delete(user);
		
		return "user record deleted successfully";
	
	}

	@Override
	public String deleteUserById(int id) throws UserNotFoundException{

		User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException("user record not found"));
		
		repository.delete(user);
		
		return "user record deleted successfully";
	
	}

}
