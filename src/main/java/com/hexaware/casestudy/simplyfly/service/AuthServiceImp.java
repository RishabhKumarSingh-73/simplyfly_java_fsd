package com.hexaware.casestudy.simplyfly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.user.LoginDto;
import com.hexaware.casestudy.simplyfly.dto.user.LoginResponseDto;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

@Service
public class AuthServiceImp implements IAuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponseDto login(LoginDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(token);
        response.setRole(user.getRole().name());
        response.setEmail(user.getEmail());

        return response;
    }
}
