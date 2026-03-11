package com.hexaware.casestudy.simplyfly.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatingRequestDto {

    @NotBlank(message = "username cannot be blank")
	private String username;

    @Email(message = "invalid email format")
	private String email;

    @NotBlank(message = "password cannot be blank")
	private String passwordHash;
}
