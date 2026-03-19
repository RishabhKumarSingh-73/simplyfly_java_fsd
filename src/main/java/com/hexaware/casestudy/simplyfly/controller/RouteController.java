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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.casestudy.simplyfly.dto.route.RouteAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.route.RouteResponseDto;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.service.RouteServiceImp;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteServiceImp service;

//    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER')")
    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping
    public List<RouteResponseDto> getAllRoutes() {
        return service.getAllRoutes();
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/{id}")
    public RouteResponseDto getRouteById(@PathVariable int id) throws RouteNotFoundException {
        return service.getRouteById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FLIGHT_OWNER','CUSTOMER')")
    @GetMapping("/search")
    public RouteResponseDto getRoute(@RequestParam String source,
                          @RequestParam String destination) throws RouteNotFoundException {
        return service.getRouteBySourceAndDestination(source, destination);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public RouteResponseDto addRoute(@RequestBody RouteAddingRequestDto routeDto) {
        return service.addRoute(routeDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public RouteResponseDto updateRoute(@RequestBody RouteAddingRequestDto routeDto,@PathVariable int id) throws RouteNotFoundException,ServiceNotAllowedException {
        return service.updateRoute(routeDto,id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteRoute(@PathVariable int id) throws RouteNotFoundException,ServiceNotAllowedException {
        return service.deleteRouteById(id);
    }
}
