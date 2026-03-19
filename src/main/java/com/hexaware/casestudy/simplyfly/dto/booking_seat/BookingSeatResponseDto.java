package com.hexaware.casestudy.simplyfly.dto.booking_seat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingSeatResponseDto {
	
	private int id;
	private int bookingId;
	private int flightSeatId;
	private double pricePaid;

}
