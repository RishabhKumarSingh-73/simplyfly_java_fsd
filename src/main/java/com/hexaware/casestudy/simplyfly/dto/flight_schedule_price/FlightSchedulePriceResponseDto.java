package com.hexaware.casestudy.simplyfly.dto.flight_schedule_price;

import com.hexaware.casestudy.simplyfly.enums.SeatClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSchedulePriceResponseDto {

    private int id;
	
	private int flightScheduleId;
	
	private SeatClass seatClass;
	
	private double basePrice;
}
