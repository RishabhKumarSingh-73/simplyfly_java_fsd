package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.FlightScheduleCreateDTO;
import com.hexaware.casestudy.simplyfly.dto.FlightScheduleResponseDTO;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.service.FlightScheduleServiceImp;

@RestController
@RequestMapping("/api/flight-schedules")
public class FlightScheduleController {

    @Autowired
    private FlightScheduleServiceImp service;

    @GetMapping
    public List<FlightSchedule> getAllSchedules() {
        return service.getAllFlightSchedules();
    }

    @GetMapping("/{id}")
    public FlightSchedule getScheduleById(@PathVariable int id) throws FlightScheduleNotFoundException {
        return service.getFlightScheduleById(id);
    }

    @PostMapping
    public FlightScheduleResponseDTO addSchedule(@RequestBody FlightScheduleCreateDTO dto)
            throws FlightNotFoundException, RouteNotFoundException {
        return service.addFlightSchedule(dto);
    }

    @PutMapping("/{id}/{status}")
    public FlightSchedule updateStatus(@PathVariable int id,
                                       @PathVariable FlightScheduleStatus status)
            throws FlightScheduleNotFoundException {
        return service.updateFlightScheduleStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String cancelSchedule(@PathVariable int id) throws FlightScheduleNotFoundException {
        return service.cancelFlightSchedule(id);
    }
}
