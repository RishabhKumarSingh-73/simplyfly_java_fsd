package com.hexaware.casestudy.simplyfly.dto.user;

import com.hexaware.casestudy.simplyfly.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddingRequestDto {

    @NotBlank(message = "username cannot be blank")
	private String username;

    @Email(message = "invalid email format")
	private String email;

    @NotBlank(message = "password cannot be blank")
	private String passwordHash;

    @NotNull(message = "role cannot be null")
	private Role role;

}
