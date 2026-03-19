package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.route.RouteAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.route.RouteResponseDto;
import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.mapper.RouteMapper;
import com.hexaware.casestudy.simplyfly.repository.FlightScheduleRepository;
import com.hexaware.casestudy.simplyfly.repository.RouteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteServiceImp implements IRouteService {
	
	@Autowired
	private RouteRepository repository;
	
	@Autowired
	private FlightScheduleRepository flightScheduleRepository;

	@Override
	public List<RouteResponseDto> getAllRoutes() {

		return repository.findAll().stream().map(entity->{
			return RouteMapper.routeToRouteResponseDto(entity);
		}).toList();
	
	}

	@Override
	public RouteResponseDto getRouteById(int id) throws RouteNotFoundException{
		
		Route route = repository.findById(id).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
		return RouteMapper.routeToRouteResponseDto(route);
		
	}

	@Override
	public RouteResponseDto getRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode) throws RouteNotFoundException{

		Route route = repository.findBySourceAirportCodeAndDestinationAirportCode(sourceAirportCode, destinationAirportCode).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
		return RouteMapper.routeToRouteResponseDto(route);
		
	}

	@Override
	public RouteResponseDto addRoute(RouteAddingRequestDto routeDto) {
		
		Route route = RouteMapper.routeAddingRequestDtoToRoute(routeDto);

		return RouteMapper.routeToRouteResponseDto(route);
		
	}

	@Override
	public RouteResponseDto updateRoute(RouteAddingRequestDto routeDto,int id) throws RouteNotFoundException,ServiceNotAllowedException{

		Route route = repository.findById(id).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
		if(flightScheduleRepository.findByRoute_Id(id) != null)throw new ServiceNotAllowedException("updating route with active schedule is not allowed");
		
		route = RouteMapper.routeAddingRequestDtoToRoute(routeDto);
		route.setId(id);
		
		return RouteMapper.routeToRouteResponseDto(repository.save(route));
		
	}

	@Override
	public String deleteRouteById(int id) throws RouteNotFoundException,ServiceNotAllowedException{

		Route route = repository.findById(id).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
		if(flightScheduleRepository.findByRoute_Id(id) != null)throw new ServiceNotAllowedException("deleting route with active schedule is not allowed");
		
		repository.delete(route);
		
		return "record deleted successfully.";
		
	}

}
