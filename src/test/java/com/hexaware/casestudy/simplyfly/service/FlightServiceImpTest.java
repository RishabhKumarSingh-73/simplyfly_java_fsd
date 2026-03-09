package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FlightServiceImpTest {

    @Autowired
    private FlightServiceImp service;

    @Autowired
    private FlightRepository repository;

    private Flight createFlightRecord() {

        User owner = new User();
        owner.setId(1);

        AircraftModel model = new AircraftModel();
        model.setId(1);

        Flight flight = new Flight();
        flight.setFlightNumber("AI101");
        flight.setOwner(owner);
        flight.setAircraftModel(model);
        flight.setActive(true);

        return repository.save(flight);
    }

    @Test
    void testGetAllFlights() {

        createFlightRecord();

        List<Flight> list = service.getAllFlights();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetFlightById() throws FlightNotFoundException {

        Flight saved = createFlightRecord();

        Flight flight = service.getFlightById(saved.getId());

        assertEquals(saved.getId(), flight.getId());
    }

    @Test
    void testGetFlightByNumber() throws FlightNotFoundException {

        Flight saved = createFlightRecord();

        Flight flight = service.getFlightByNumber(saved.getFlightNumber());

        assertEquals(saved.getFlightNumber(), flight.getFlightNumber());
    }

    @Test
    void testGetFlightsByOwnerId() {

        createFlightRecord();

        List<Flight> list = service.getFlightsByOwnerId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testAddFlight() {

        Flight saved = createFlightRecord();

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testUpdateFlight() throws FlightNotFoundException {

        Flight saved = createFlightRecord();

        saved.setFlightNumber("AI202");

        Flight updated = service.updateFlight(saved);

        assertEquals("AI202", updated.getFlightNumber());
    }

    @Test
    void testDeleteFlightById() throws FlightNotFoundException {

        Flight saved = createFlightRecord();

        String result = service.deleteFlightById(saved.getId());

        assertEquals("record deleted successfully.", result);
    }
}