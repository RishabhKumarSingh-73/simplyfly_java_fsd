package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.route.RouteAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.route.RouteResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Route;

public class RouteMapper {

	public static Route routeAddingRequestDtoToRoute(RouteAddingRequestDto dto) {
		
		if(dto == null)return null;
		
		Route route = new Route();
		route.setSourceAirportCode(dto.getSourceAirportCode());
		route.setDestinationAirportCode(dto.getDestinationAirportCode());
		route.setSourceCity(dto.getSourceCity());
		route.setDestinationCity(dto.getDestinationCity());
		
		return route;
		
	}
	
	public static RouteResponseDto routeToRouteResponseDto(Route route) {
		
		if(route == null)return null;
		
		RouteResponseDto dto = new RouteResponseDto();
		dto.setId(route.getId());
		dto.setDestinationAirportCode(route.getDestinationAirportCode());
		dto.setDestinationCity(route.getDestinationCity());
		dto.setSourceAirportCode(route.getSourceAirportCode());
		dto.setSourceCity(route.getSourceCity());
		
		return dto;
		
	}
}
