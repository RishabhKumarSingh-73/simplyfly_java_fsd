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

import com.hexaware.casestudy.simplyfly.dto.seat.SeatAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.seat.SeatResponseDto;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;
import com.hexaware.casestudy.simplyfly.service.SeatServiceImp;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatServiceImp service;

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/aircraft/{aircraftModelId}")
    public List<SeatResponseDto> getSeatsByAircraftModel(@PathVariable int aircraftModelId) {
        return service.getSeatsByAircraftModelId(aircraftModelId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/{id}")
    public SeatResponseDto getSeatById(@PathVariable int id) throws SeatNotFoundException {
        return service.getSeatById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public SeatResponseDto addSeat(@RequestBody SeatAddingRequestDto seatDto)throws AircraftModelNotFoundException {
        return service.addSeat(seatDto);
    }

//    @PutMapping
//    public Seat updateSeat(@RequestBody SeatAddingRequestDto seatDto) throws SeatNotFoundException {
//        return service.updateSeat(seat);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteSeat(@PathVariable int id) throws SeatNotFoundException {
//        return service.deleteSeatById(id);
//    }
}
