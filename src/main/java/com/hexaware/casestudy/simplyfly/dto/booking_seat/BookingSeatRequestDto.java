package com.hexaware.casestudy.simplyfly.dto.booking_seat;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingSeatRequestDto {
	
	@NotNull(message = "booking id cant be null")
	private int bookingId;
	@NotNull(message = "flightSeat id cant be null")
	private int flightSeatId;
	@NotNull(message = "pricePaid cant be null")
	private double pricePaid;

}
