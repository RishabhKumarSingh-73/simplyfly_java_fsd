package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.Route;

public interface IRouteService {
	
	List<Route> getAllRoutes();
    Route getRouteById(int id);
    Route getRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode);
    int addRoute(Route route);
    int updateRoute(Route route);
    int deleteRouteById(int id);
    
}
