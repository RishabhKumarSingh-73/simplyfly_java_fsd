package com.hexaware.casestudy.simplyfly.dto.flight_schedule_price;


import com.hexaware.casestudy.simplyfly.enums.SeatClass;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSchedulePriceDTO {

	@NotNull(message = "seat Class cant be null")
	private SeatClass seatClass;
	@NotNull(message = "base Price cant be null")
    private double basePrice;


}
