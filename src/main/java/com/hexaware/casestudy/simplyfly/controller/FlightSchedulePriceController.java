package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule_price.FlightSchedulePriceResponseDto;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.service.FlightSchedulePriceServiceImp;

@RestController
@RequestMapping("/api/flight-schedule-prices")
public class FlightSchedulePriceController {

    @Autowired
    private FlightSchedulePriceServiceImp service;

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/schedule/{scheduleId}")
    public List<FlightSchedulePriceResponseDto> getPricesByScheduleId(@PathVariable int scheduleId) {
        return service.getPricesByScheduleId(scheduleId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/schedule/{scheduleId}/class/{seatClass}")
    public FlightSchedulePriceResponseDto getPriceByScheduleAndClass(
            @PathVariable int scheduleId,
            @PathVariable SeatClass seatClass)
            throws FlightSchedulePriceNotFoundException {

        return service.getPriceByScheduleAndClass(scheduleId, seatClass);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PostMapping
    public FlightSchedulePriceResponseDto addPrice(@RequestBody FlightSchedulePriceAddingRequestDto priceDto)throws FlightScheduleNotFoundException,ServiceNotAllowedException {
        return service.addPrice(priceDto);
    }

    
}
