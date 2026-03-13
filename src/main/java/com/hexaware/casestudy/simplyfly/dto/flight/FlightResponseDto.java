package com.hexaware.casestudy.simplyfly.dto.flight;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.User;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponseDto {

	
	private int id;
	
	private String flightNumber;
	
	private User owner;
	
	private AircraftModel aircraftModel;
	
	private boolean isActive;
	
}
