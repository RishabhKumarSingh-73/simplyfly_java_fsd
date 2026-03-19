package com.hexaware.casestudy.simplyfly.dto.route;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponseDto {

	private int id;
	private String sourceAirportCode;
	private String destinationAirportCode;
	private String sourceCity;
	private String destinationCity;
	
}
