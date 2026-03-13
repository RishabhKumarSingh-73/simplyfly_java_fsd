package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.user.UserAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserResponseDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserUpdatingRequestDto;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.service.UserServiceImp;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImp service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return service.getAllUsers();
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/{email}")
    public UserResponseDto getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return service.getUserByEmail(email);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @PostMapping
    public UserResponseDto addUser(@RequestBody UserAddingRequestDto user)throws ServiceNotAllowedException {
        return service.addUser(user);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @PutMapping("/{userid}")
    public UserResponseDto updateUser(@RequestBody UserUpdatingRequestDto user,@PathVariable int userid) throws UserNotFoundException {
        return service.updateUser(user,userid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/deactivate/email/{email}")
    public String deactivateUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return service.deactivateUserByEmail(email);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/deactivate/id/{id}")
    public String deactivateUserById(@PathVariable int id) throws UserNotFoundException {
        return service.deactivateUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/activate/email/{email}")
    public String activateUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return service.activateUserByEmail(email);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/activate/id/{id}")
    public String activateUserById(@PathVariable int id) throws UserNotFoundException {
        return service.activateUserById(id);
    }
}