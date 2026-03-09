package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.RouteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteServiceImp implements IRouteService {
	
	private RouteRepository repository;

	@Override
	public List<Route> getAllRoutes() {

		return repository.findAll();
	
	}

	@Override
	public Route getRouteById(int id) throws RouteNotFoundException{
		
		return repository.findById(id).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
	}

	@Override
	public Route getRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode) throws RouteNotFoundException{

		return repository.findBySourceAirportCodeAndDestinationAirportCode(sourceAirportCode, destinationAirportCode).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
	}

	@Override
	public Route addRoute(Route route) {

		return repository.save(route);
		
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException{

		repository.findById(route.getId()).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
		return repository.save(route);
		
	}

	@Override
	public String deleteRouteById(int id) throws RouteNotFoundException{

		Route route = repository.findById(id).orElseThrow(()-> new RouteNotFoundException("Route record not found."));
		
		repository.delete(route);
		
		return "record deleted successfully.";
		
	}

}
