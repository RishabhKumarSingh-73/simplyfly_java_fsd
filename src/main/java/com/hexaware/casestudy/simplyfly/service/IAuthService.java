package com.hexaware.casestudy.simplyfly.service;

import com.hexaware.casestudy.simplyfly.dto.user.LoginDto;
import com.hexaware.casestudy.simplyfly.dto.user.LoginResponseDto;
import com.hexaware.casestudy.simplyfly.exception.InvalidPasswordException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;

public interface IAuthService {

	LoginResponseDto login(LoginDto dto)throws UserNotFoundException,InvalidPasswordException ;
}
