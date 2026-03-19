package com.hexaware.casestudy.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.service.FlightServiceImp;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightServiceImp service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<FlightResponseDto> getAllFlights() {
        return service.getAllFlights();
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/{id}")
    public FlightResponseDto getFlightById(@PathVariable int id) throws FlightNotFoundException {
        return service.getFlightById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/number/{number}")
    public FlightResponseDto getFlightByNumber(@PathVariable String number) throws FlightNotFoundException {
        return service.getFlightByNumber(number);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/owner/{ownerId}")
    public List<FlightResponseDto> getFlightsByOwner(@PathVariable int ownerId) {
        return service.getFlightsByOwnerId(ownerId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PostMapping
    public FlightResponseDto addFlight(@RequestBody FlightAddingRequestDto flight)throws UserNotFoundException,AircraftModelNotFoundException  {
        return service.addFlight(flight);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PatchMapping("/deactivate/{id}")
    public FlightResponseDto deactivateFlight(@PathVariable int id) throws FlightNotFoundException,ServiceNotAllowedException {
        return service.deactivateFlight(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PatchMapping("/activate/{id}")
    public FlightResponseDto activateFlight(@PathVariable int id) throws FlightNotFoundException,ServiceNotAllowedException {
        return service.deactivateFlight(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable int id) throws FlightNotFoundException,ServiceNotAllowedException {
        return service.deleteFlightById(id);
    }
}
