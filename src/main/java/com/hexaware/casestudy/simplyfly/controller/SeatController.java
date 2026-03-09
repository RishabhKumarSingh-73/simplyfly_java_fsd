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

import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;
import com.hexaware.casestudy.simplyfly.service.SeatServiceImp;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatServiceImp service;

    @GetMapping("/aircraft/{aircraftModelId}")
    public List<Seat> getSeatsByAircraftModel(@PathVariable int aircraftModelId) {
        return service.getSeatsByAircraftModelId(aircraftModelId);
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable int id) throws SeatNotFoundException {
        return service.getSeatById(id);
    }

    @PostMapping
    public Seat addSeat(@RequestBody Seat seat) {
        return service.addSeat(seat);
    }

    @PutMapping
    public Seat updateSeat(@RequestBody Seat seat) throws SeatNotFoundException {
        return service.updateSeat(seat);
    }

    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable int id) throws SeatNotFoundException {
        return service.deleteSeatById(id);
    }
}
