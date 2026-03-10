package com.hexaware.casestudy.simplyfly.dto.user;

import com.hexaware.casestudy.simplyfly.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private int id;
	private String username;
	private String email;
	private String passwordHash;
	private Role role;
	private boolean isActive;
	
}
