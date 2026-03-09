package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.service.FlightSeatServiceImp;

@RestController
@RequestMapping("/api/flight-seats")
public class FlightSeatController {

    @Autowired
    private FlightSeatServiceImp service;

    @GetMapping("/schedule/{scheduleId}")
    public List<FlightSeat> getSeatsBySchedule(@PathVariable int scheduleId) {
        return service.getSeatsByScheduleId(scheduleId);
    }

    @GetMapping("/available/{scheduleId}")
    public List<FlightSeat> getAvailableSeats(@PathVariable int scheduleId) {
        return service.getAvailableSeatsByScheduleId(scheduleId);
    }

    @GetMapping("/{id}")
    public FlightSeat getSeatById(@PathVariable int id) throws FlightSeatNotFoundException {
        return service.getFlightSeatById(id);
    }

    @PutMapping("/{id}/{status}")
    public FlightSeat updateSeatStatus(@PathVariable int id,
                                       @PathVariable FlightSeatStatus status)
            throws FlightSeatNotFoundException {
        return service.updateSeatStatus(id, status);
    }
}
