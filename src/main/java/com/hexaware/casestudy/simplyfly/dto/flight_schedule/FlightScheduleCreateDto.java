package com.hexaware.casestudy.simplyfly.dto.flight_schedule;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightScheduleCreateDto {


	@NotNull(message = "flight id cant be null")
    private int flightId;
	@NotNull(message = "route id cant be null")
    private int routeId;

	@NotNull(message = "departure Datetime cant be null")
    private LocalDateTime departureDatetime;
	@NotNull(message = "arrival Datetime cant be null")
    private LocalDateTime arrivalDatetime;

	@NotNull(message = "prices cant be null")
    private List<FlightSchedulePriceDTO> prices;

    
}

