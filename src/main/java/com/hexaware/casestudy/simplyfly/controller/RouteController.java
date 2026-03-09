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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.service.RouteServiceImp;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteServiceImp service;

    @GetMapping
    public List<Route> getAllRoutes() {
        return service.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable int id) throws RouteNotFoundException {
        return service.getRouteById(id);
    }

    @GetMapping("/search")
    public Route getRoute(@RequestParam String source,
                          @RequestParam String destination) throws RouteNotFoundException {
        return service.getRouteBySourceAndDestination(source, destination);
    }

    @PostMapping
    public Route addRoute(@RequestBody Route route) {
        return service.addRoute(route);
    }

    @PutMapping
    public Route updateRoute(@RequestBody Route route) throws RouteNotFoundException {
        return service.updateRoute(route);
    }

    @DeleteMapping("/{id}")
    public String deleteRoute(@PathVariable int id) throws RouteNotFoundException {
        return service.deleteRouteById(id);
    }
}
