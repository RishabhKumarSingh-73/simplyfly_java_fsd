package com.hexaware.casestudy.simplyfly.service;

import com.hexaware.casestudy.simplyfly.dto.user.LoginDto;
import com.hexaware.casestudy.simplyfly.dto.user.LoginResponseDto;

public interface IAuthService {

	LoginResponseDto login(LoginDto dto);
}
