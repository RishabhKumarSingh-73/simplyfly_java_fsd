package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.dto.flight.FlightAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.flight.FlightResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

@SpringBootTest
class FlightServiceImpTest {

    @Autowired
    private FlightServiceImp service;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AircraftModelRepository aircraftModelRepository;

    private User createUser() {
        User user = new User();
        user.setUsername("owner1");
        user.setEmail("owner@email.com");
        user.setPasswordHash("pass");
        user.setRole(Role.FLIGHT_OWNER);
        user.setActive(true);

        return userRepository.save(user);
    }

    private AircraftModel createAircraftModel() {
        AircraftModel model = new AircraftModel();
        model.setModelName("A320");
        model.setManufacturer("Airbus");
        model.setTotalRows(30);
        model.setLayoutDescription("3-3");

        return aircraftModelRepository.save(model);
    }

    private Flight createFlight() {

        User owner = createUser();
        AircraftModel model = createAircraftModel();

        Flight flight = new Flight();
        flight.setFlightNumber("AI101");
        flight.setOwner(owner);
        flight.setAircraftModel(model);
        flight.setActive(true);

        return flightRepository.save(flight);
    }

    @Test
    void testGetAllFlights() {

        createFlight();

        List<FlightResponseDto> list = service.getAllFlights();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetFlightById() throws FlightNotFoundException {

        Flight saved = createFlight();

        FlightResponseDto response = service.getFlightById(saved.getId());

        assertEquals(saved.getId(), response.getId());
    }

    @Test
    void testGetFlightByNumber() throws FlightNotFoundException {

        Flight saved = createFlight();

        FlightResponseDto response = service.getFlightByNumber(saved.getFlightNumber());

        assertEquals(saved.getFlightNumber(), response.getFlightNumber());
    }

    @Test
    void testGetFlightsByOwnerId() {

        Flight saved = createFlight();

        List<FlightResponseDto> list = service.getFlightsByOwnerId(saved.getOwner().getId());

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testAddFlight() throws UserNotFoundException, AircraftModelNotFoundException {

        User owner = createUser();
        AircraftModel model = createAircraftModel();

        FlightAddingRequestDto dto = new FlightAddingRequestDto();
        dto.setFlightNumber("AI202");
        dto.setOwnerId(owner.getId());
        dto.setAircraftModelId(model.getId());

        FlightResponseDto response = service.addFlight(dto);

        assertNotNull(response);
        assertEquals("AI202", response.getFlightNumber());
    }

    @Test
    void testDeactivateFlight() throws FlightNotFoundException {

        Flight saved = createFlight();

        FlightResponseDto response = service.deactivateFlight(saved.getId());

        assertFalse(response.isActive());
    }

    @Test
    void testActivateFlight() throws FlightNotFoundException {

        Flight saved = createFlight();
        saved.setActive(false);
        flightRepository.save(saved);

        FlightResponseDto response = service.activateFlight(saved.getId());

        assertTrue(response.isActive());
    }

    @Test
    void testDeleteFlightById() throws FlightNotFoundException, ServiceNotAllowedException {

        Flight saved = createFlight();

        String result = service.deleteFlightById(saved.getId());

        assertEquals("record deleted successfully.", result);
    }
}