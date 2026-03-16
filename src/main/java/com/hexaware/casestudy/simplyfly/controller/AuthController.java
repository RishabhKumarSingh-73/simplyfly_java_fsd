package com.hexaware.casestudy.simplyfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.user.LoginDto;
import com.hexaware.casestudy.simplyfly.dto.user.LoginResponseDto;
import com.hexaware.casestudy.simplyfly.service.AuthServiceImp;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthServiceImp authService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginDto dto) {
        return authService.login(dto);
    }
}