package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.route.RouteAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.route.RouteResponseDto;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;

public interface IRouteService {
	
	List<RouteResponseDto> getAllRoutes();
	RouteResponseDto getRouteById(int id) throws RouteNotFoundException;
	RouteResponseDto getRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode)throws RouteNotFoundException;
	RouteResponseDto addRoute(RouteAddingRequestDto routeDto);
	RouteResponseDto updateRoute(RouteAddingRequestDto routeDto,int id)throws RouteNotFoundException,ServiceNotAllowedException;
    String deleteRouteById(int id)throws RouteNotFoundException,ServiceNotAllowedException;
    
}
