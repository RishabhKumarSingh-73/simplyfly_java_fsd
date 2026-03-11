package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.user.*;
import com.hexaware.casestudy.simplyfly.entity.User;

public class UserMapper {

    public static UserResponseDto entityToUserResponseDto(User user) {
        if (user == null) {
            return null;
        }
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPasswordHash(user.getPasswordHash());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());
        return dto;
    }



    public static User userAddingRequestDtoToEntity(UserAddingRequestDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPasswordHash());
        user.setRole(dto.getRole());
        return user;
    }

}
