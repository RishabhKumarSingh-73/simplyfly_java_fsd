package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.Role;
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
        user.setEmail("test@email.com");
        user.setPasswordHash("password123");
        user.setRole(Role.CUSTOMER);
        user.setActive(true);

        return repository.save(user);
    }

    @Test
    void testGetAllUsers() {

        createUserRecord();

        List<User> list = service.getAllUsers();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetUserByEmail() throws UserNotFoundException {

        User saved = createUserRecord();

        User user = service.getUserByEmail(saved.getEmail());

        assertEquals(saved.getEmail(), user.getEmail());
    }

    @Test
    void testAddUser() {

        User saved = createUserRecord();

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testUpdateUser() throws UserNotFoundException {

        User saved = createUserRecord();

        saved.setUsername("updatedUser");

        User updated = service.updateUser(saved);

        assertEquals("updatedUser", updated.getUsername());
    }

    @Test
    void testDeleteUserByEmail() throws UserNotFoundException {

        User saved = createUserRecord();

        String result = service.deleteUserByEmail(saved.getEmail());

        assertEquals("user record deleted successfully", result);
    }

    @Test
    void testDeleteUserById() throws UserNotFoundException {

        User saved = createUserRecord();

        String result = service.deleteUserById(saved.getId());

        assertEquals("user record deleted successfully", result);
    }
}