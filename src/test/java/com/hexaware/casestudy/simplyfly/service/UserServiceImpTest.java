package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.dto.user.UserAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserResponseDto;
import com.hexaware.casestudy.simplyfly.dto.user.UserUpdatingRequestDto;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class UserServiceImpTest {

    @Autowired
    private UserServiceImp service;

    @Autowired
    private UserRepository repository;

    private User createUserRecord() {

        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@email.com");
        user.setPasswordHash("password123");
        user.setRole(Role.CUSTOMER);
        user.setActive(true);

        return repository.save(user);
    }

    @Test
    void testGetAllUsers() {

        createUserRecord();

        List<UserResponseDto> list = service.getAllUsers();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetUserByEmail() throws UserNotFoundException {

        User saved = createUserRecord();

        UserResponseDto user = service.getUserByEmail(saved.getEmail());

        assertEquals(saved.getEmail(), user.getEmail());
    }

    @Test
    void testAddUser() throws ServiceNotAllowedException {

        UserAddingRequestDto dto = new UserAddingRequestDto();
        dto.setUsername("newuser");
        dto.setEmail("newuser@email.com");
        dto.setPasswordHash("password");
        dto.setRole(Role.CUSTOMER);

        UserResponseDto response = service.addUser(dto);

        assertNotNull(response);
        assertEquals("newuser@email.com", response.getEmail());
    }

    @Test
    void testUpdateUser() throws UserNotFoundException {

        User saved = createUserRecord();

        UserUpdatingRequestDto dto = new UserUpdatingRequestDto();
        dto.setUsername("updateduser");
        dto.setEmail("updated@email.com");
        dto.setPasswordHash("updatedpass");

        UserResponseDto updated = service.updateUser(dto, saved.getId());

        assertEquals("updated@email.com", updated.getEmail());
    }

    @Test
    void testDeactivateUserByEmail() throws UserNotFoundException {

        User saved = createUserRecord();

        String result = service.deactivateUserByEmail(saved.getEmail());

        assertEquals("user record deactivated successfully", result);
    }

    @Test
    void testDeactivateUserById() throws UserNotFoundException {

        User saved = createUserRecord();

        String result = service.deactivateUserById(saved.getId());

        assertEquals("user record deactivated successfully", result);
    }

    @Test
    void testActivateUserByEmail() throws UserNotFoundException {

        User saved = createUserRecord();
        saved.setActive(false);
        repository.save(saved);

        String result = service.activateUserByEmail(saved.getEmail());

        assertEquals("user record activated successfully", result);
    }

    @Test
    void testActivateUserById() throws UserNotFoundException {

        User saved = createUserRecord();
        saved.setActive(false);
        repository.save(saved);

        String result = service.activateUserById(saved.getId());

        assertEquals("user record activated successfully", result);
    }
}