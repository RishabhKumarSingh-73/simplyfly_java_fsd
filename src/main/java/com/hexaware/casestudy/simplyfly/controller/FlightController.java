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

import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.service.FlightServiceImp;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightServiceImp service;

    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable int id) throws FlightNotFoundException {
        return service.getFlightById(id);
    }

    @GetMapping("/number/{number}")
    public Flight getFlightByNumber(@PathVariable String number) throws FlightNotFoundException {
        return service.getFlightByNumber(number);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Flight> getFlightsByOwner(@PathVariable int ownerId) {
        return service.getFlightsByOwnerId(ownerId);
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return service.addFlight(flight);
    }

    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight) throws FlightNotFoundException {
        return service.updateFlight(flight);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable int id) throws FlightNotFoundException {
        return service.deleteFlightById(id);
    }
}
