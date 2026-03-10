package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.service.UserServiceImp;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImp service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return service.getUserByEmail(email);
    }

    @PostMapping
    public User addUser(@RequestBody User user)throws ServiceNotAllowedException {
        return service.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) throws UserNotFoundException {
        return service.updateUser(user);
    }

    @DeleteMapping("/email/{email}")
    public String deleteUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return service.deleteUserByEmail(email);
    }

    @DeleteMapping("/id/{id}")
    public String deleteUserById(@PathVariable int id) throws UserNotFoundException {
        return service.deleteUserById(id);
    }
}