package com.hexaware.casestudy.simplyfly.dto.user;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

	@NotBlank(message = "email cant be blank")
	private String email;
	@NotBlank(message = "password cant be blank")
    private String password;
    
}
