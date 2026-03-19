package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.flight_seat.FlightSeatResponseDto;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.service.FlightSeatServiceImp;

@RestController
@RequestMapping("/api/flight-seats")
public class FlightSeatController {

    @Autowired
    private FlightSeatServiceImp service;

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/schedule/{scheduleId}")
    public List<FlightSeatResponseDto> getSeatsBySchedule(@PathVariable int scheduleId) {
        return service.getSeatsByScheduleId(scheduleId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/available/{scheduleId}")
    public List<FlightSeatResponseDto> getAvailableSeats(@PathVariable int scheduleId) {
        return service.getAvailableSeatsByScheduleId(scheduleId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/{id}")
    public FlightSeatResponseDto getSeatById(@PathVariable int id) throws FlightSeatNotFoundException {
        return service.getFlightSeatById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @PutMapping("/{id}/{status}")
    public FlightSeatResponseDto updateSeatStatus(@PathVariable int id,
                                       @PathVariable FlightSeatStatus status)
            throws FlightSeatNotFoundException {
        return service.updateSeatStatus(id, status);
    }
}
