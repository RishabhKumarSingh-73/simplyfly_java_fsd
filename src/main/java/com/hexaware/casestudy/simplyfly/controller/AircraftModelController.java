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

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.service.AircraftModelServiceImp;

@RestController
@RequestMapping("/api/aircraft-models")
public class AircraftModelController {

    @Autowired
    private AircraftModelServiceImp service;

    @GetMapping
    public List<AircraftModel> getAllAircraftModels() {
        return service.getAllAircraftModels();
    }

    @GetMapping("/{id}")
    public AircraftModel getAircraftModelById(@PathVariable int id) throws AircraftModelNotFoundException {
        return service.getAircraftModelById(id);
    }

    @GetMapping("/name/{name}")
    public AircraftModel getAircraftModelByName(@PathVariable String name) throws AircraftModelNotFoundException {
        return service.getAircraftModelByName(name);
    }

    @PostMapping
    public AircraftModel addAircraftModel(@RequestBody AircraftModel model) {
        return service.addAircraftModel(model);
    }

    @PutMapping
    public AircraftModel updateAircraftModel(@RequestBody AircraftModel model) throws AircraftModelNotFoundException {
        return service.updateAircraftModel(model);
    }

    @DeleteMapping("/{id}")
    public String deleteAircraftModel(@PathVariable int id) throws AircraftModelNotFoundException {
        return service.deleteAircraftModelById(id);
    }
}