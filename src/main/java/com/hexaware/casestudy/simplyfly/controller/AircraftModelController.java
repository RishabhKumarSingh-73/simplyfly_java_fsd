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

import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelResponseDto;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.service.AircraftModelServiceImp;

@RestController
@RequestMapping("/api/aircraft-models")
public class AircraftModelController {

    @Autowired
    private AircraftModelServiceImp service;

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping
    public List<AircraftModelResponseDto> getAllAircraftModels() {
        return service.getAllAircraftModels();
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/{id}")
    public AircraftModelResponseDto getAircraftModelById(@PathVariable int id) throws AircraftModelNotFoundException {
        return service.getAircraftModelById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @GetMapping("/name/{name}")
    public AircraftModelResponseDto getAircraftModelByName(@PathVariable String name) throws AircraftModelNotFoundException {
        return service.getAircraftModelByName(name);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public AircraftModelResponseDto addAircraftModel(@RequestBody AircraftModelAddingRequestDto model) {
        return service.addAircraftModel(model);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/{manufacturer}")
    public AircraftModelResponseDto updateAircraftModel(@PathVariable String manufacturer,@PathVariable int id) throws AircraftModelNotFoundException {
        return service.updateAircraftModelManufacturer(manufacturer,id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteAircraftModel(@PathVariable int id) throws AircraftModelNotFoundException,ServiceNotAllowedException {
        return service.deleteAircraftModelById(id);
    }
}