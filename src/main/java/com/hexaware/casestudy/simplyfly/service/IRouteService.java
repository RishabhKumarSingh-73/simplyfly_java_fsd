package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;

public interface IRouteService {
	
	List<Route> getAllRoutes();
    Route getRouteById(int id) throws RouteNotFoundException;
    Route getRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode)throws RouteNotFoundException;
    Route addRoute(Route route);
    Route updateRoute(Route route)throws RouteNotFoundException;
    String deleteRouteById(int id)throws RouteNotFoundException;
    
}
