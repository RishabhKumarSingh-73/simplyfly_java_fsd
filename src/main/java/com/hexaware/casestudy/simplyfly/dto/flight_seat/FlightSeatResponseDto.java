package com.hexaware.casestudy.simplyfly.dto.flight_seat;


import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSeatResponseDto {

	private int id;
	private int flightScheduleId;
	private int seatId;
	private FlightSeatStatus status;
	
}
