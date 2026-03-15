package com.hexaware.casestudy.simplyfly.dto.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightAddingRequestDto{
	
	private String flightNumber;
	
	private int ownerId;
	
	private int aircraftModelId;
	
	private boolean isActive;

}