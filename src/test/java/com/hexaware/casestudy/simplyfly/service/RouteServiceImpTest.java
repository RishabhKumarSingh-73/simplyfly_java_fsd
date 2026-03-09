package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.RouteRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class RouteServiceImpTest {

    @Autowired
    private RouteServiceImp service;

    @Autowired
    private RouteRepository repository;

    private Route createRouteRecord() {

        Route route = new Route();
        route.setSourceAirportCode("DEL");
        route.setDestinationAirportCode("BLR");
        route.setSourceCity("Delhi");
        route.setDestinationCity("Bangalore");

        return repository.save(route);
    }

    @Test
    void testGetAllRoutes() {

        createRouteRecord();

        List<Route> list = service.getAllRoutes();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetRouteById() throws RouteNotFoundException {

        Route saved = createRouteRecord();

        Route route = service.getRouteById(saved.getId());

        assertEquals(saved.getId(), route.getId());
    }

    @Test
    void testGetRouteBySourceAndDestination() throws RouteNotFoundException {

        Route saved = createRouteRecord();

        Route route =
                service.getRouteBySourceAndDestination(
                        saved.getSourceAirportCode(),
                        saved.getDestinationAirportCode()
                );

        assertEquals(saved.getId(), route.getId());
    }

    @Test
    void testAddRoute() {

        Route saved = createRouteRecord();

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testUpdateRoute() throws RouteNotFoundException {

        Route saved = createRouteRecord();

        saved.setSourceCity("New Delhi");

        Route updated = service.updateRoute(saved);

        assertEquals("New Delhi", updated.getSourceCity());
    }

    @Test
    void testDeleteRouteById() throws RouteNotFoundException {

        Route saved = createRouteRecord();

        String result = service.deleteRouteById(saved.getId());

        assertEquals("record deleted successfully.", result);
    }
}