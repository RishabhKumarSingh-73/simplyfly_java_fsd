package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleCreateDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleResponseDto;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.service.FlightScheduleServiceImp;

@RestController
@RequestMapping("/api/flight-schedules")
public class FlightScheduleController {

    @Autowired
    private FlightScheduleServiceImp service;

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping
    public List<FlightScheduleResponseDto> getAllSchedules() {
        return service.getAllFlightSchedules();
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/{id}")
    public FlightScheduleResponseDto getScheduleById(@PathVariable int id) throws FlightScheduleNotFoundException {
        return service.getFlightScheduleById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PostMapping
    public FlightScheduleResponseDto addSchedule(@RequestBody FlightScheduleCreateDto dto)
            throws FlightNotFoundException, RouteNotFoundException,ServiceNotAllowedException {
        return service.addFlightSchedule(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PutMapping("/{id}/{status}")
    public FlightScheduleResponseDto updateStatus(@PathVariable int id,
                                       @PathVariable FlightScheduleStatus status)
            throws FlightScheduleNotFoundException,ServiceNotAllowedException {
        return service.updateFlightScheduleStatus(id, status);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @DeleteMapping("/{id}")
    public String cancelSchedule(@PathVariable int id) throws FlightScheduleNotFoundException,ServiceNotAllowedException {
        return service.cancelFlightSchedule(id);
    }
}
