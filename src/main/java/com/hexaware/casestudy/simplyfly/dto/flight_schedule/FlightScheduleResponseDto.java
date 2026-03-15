package com.hexaware.casestudy.simplyfly.dto.flight_schedule;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceDTO;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightScheduleResponseDto {

    private int scheduleId;
    private int flightId;
    private int routeId;

    private LocalDateTime departureDatetime;
    private LocalDateTime arrivalDatetime;

    private FlightScheduleStatus status;

    private List<FlightSchedulePriceDTO> prices;

}