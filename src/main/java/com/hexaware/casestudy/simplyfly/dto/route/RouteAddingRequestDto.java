package com.hexaware.casestudy.simplyfly.dto.route;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteAddingRequestDto {
	
	@NotBlank(message = "Source Airport Code cant be blank")
	private String sourceAirportCode;
	@NotBlank(message = "Destination Airport Code cant be blank")
	private String destinationAirportCode;
	@NotBlank(message = "Source City cant be blank")
	private String sourceCity;
	@NotBlank(message = "Destination City cant be blank")
	private String destinationCity;
	
}
