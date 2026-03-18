package com.hexaware.casestudy.simplyfly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.user.LoginDto;
import com.hexaware.casestudy.simplyfly.dto.user.LoginResponseDto;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.exception.InvalidPasswordException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;
import com.hexaware.casestudy.simplyfly.security.JwtUtil;

@Service
public class AuthServiceImp implements IAuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponseDto login(LoginDto dto)throws UserNotFoundException,InvalidPasswordException {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPasswordHash())) {
            throw new InvalidPasswordException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(token);
        response.setRole(user.getRole().name());
        response.setEmail(user.getEmail());

        return response;
    }
}
