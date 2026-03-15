package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleCreateDto;
import com.hexaware.casestudy.simplyfly.dto.flight_schedule.FlightScheduleResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Flight;
import com.hexaware.casestudy.simplyfly.entity.Route;
import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.entity.User;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.enums.SeatPosition;
import com.hexaware.casestudy.simplyfly.enums.Role;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;
import com.hexaware.casestudy.simplyfly.repository.RouteRepository;
import com.hexaware.casestudy.simplyfly.repository.SeatRepository;
import com.hexaware.casestudy.simplyfly.repository.UserRepository;

@SpringBootTest
class FlightScheduleServiceImpTest {

    @Autowired
    private FlightScheduleServiceImp service;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AircraftModelRepository aircraftModelRepository;

    @Autowired
    private SeatRepository seatRepository;

    private Flight createFlight() {

        User owner = new User();
        owner.setUsername("owner1");
        owner.setEmail("owner@test.com");
        owner.setPasswordHash("pass");
        owner.setRole(Role.FLIGHT_OWNER);
        owner.setActive(true);
        owner = userRepository.save(owner);

        AircraftModel model = new AircraftModel();
        model.setModelName("A320");
        model.setManufacturer("Airbus");
        model.setTotalRows(30);
        model.setLayoutDescription("3-3");
        model = aircraftModelRepository.save(model);

        Seat seat = new Seat();
        seat.setAircraftModel(model);
        seat.setRowNumber(1);
        seat.setColumnLetter('A');
        seat.setSeatClass(SeatClass.ECONOMY);
        seat.setPositionType(SeatPosition.WINDOW);
        seatRepository.save(seat);

        Flight flight = new Flight();
        flight.setFlightNumber("AI101");
        flight.setOwner(owner);
        flight.setAircraftModel(model);
        flight.setActive(true);

        return flightRepository.save(flight);
    }

    private Route createRoute() {

        Route route = new Route();
        route.setSourceAirportCode("DEL");
        route.setDestinationAirportCode("BLR");
        route.setSourceCity("Delhi");
        route.setDestinationCity("Bangalore");

        return routeRepository.save(route);
    }

    private FlightScheduleResponseDto createSchedule() throws FlightNotFoundException, RouteNotFoundException {

        Flight flight = createFlight();
        Route route = createRoute();

        FlightScheduleCreateDto dto = new FlightScheduleCreateDto();
        dto.setFlightId(flight.getId());
        dto.setRouteId(route.getId());
        dto.setDepartureDatetime(LocalDateTime.now().plusDays(1));
        dto.setArrivalDatetime(LocalDateTime.now().plusDays(1).plusHours(2));

        return service.addFlightSchedule(dto);
    }

    @Test
    void testGetAllFlightSchedules() throws FlightNotFoundException, RouteNotFoundException {

        createSchedule();

        List<FlightScheduleResponseDto> list = service.getAllFlightSchedules();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetFlightScheduleById() throws FlightNotFoundException, RouteNotFoundException, FlightScheduleNotFoundException {

        FlightScheduleResponseDto saved = createSchedule();

        FlightScheduleResponseDto response = service.getFlightScheduleById(saved.getScheduleId());

        assertEquals(saved.getScheduleId(), response.getScheduleId());
    }

    @Test
    void testGetSchedulesByRouteAndDate() throws FlightNotFoundException, RouteNotFoundException {

        FlightScheduleResponseDto saved = createSchedule();

        List<FlightScheduleResponseDto> list =
                service.getSchedulesByRouteAndDate(
                        saved.getRouteId(),
                        saved.getDepartureDatetime());

        assertNotNull(list);
    }

    @Test
    void testGetSchedulesByFlightId() throws FlightNotFoundException, RouteNotFoundException {

        FlightScheduleResponseDto saved = createSchedule();

        List<FlightScheduleResponseDto> list =
                service.getSchedulesByFlightId(saved.getFlightId());

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testAddFlightSchedule() throws FlightNotFoundException, RouteNotFoundException {

        FlightScheduleResponseDto response = createSchedule();

        assertNotNull(response);
        assertNotNull(response.getScheduleId());
    }

    @Test
    void testUpdateFlightScheduleStatus() throws FlightNotFoundException, RouteNotFoundException, FlightScheduleNotFoundException {

        FlightScheduleResponseDto saved = createSchedule();

        FlightScheduleResponseDto updated =
                service.updateFlightScheduleStatus(saved.getScheduleId(), FlightScheduleStatus.DELAYED);

        assertEquals(FlightScheduleStatus.DELAYED.name(), updated.getStatus());
    }

    @Test
    void testCancelFlightSchedule() throws FlightNotFoundException, RouteNotFoundException, FlightScheduleNotFoundException {

        FlightScheduleResponseDto saved = createSchedule();

        String result = service.cancelFlightSchedule(saved.getScheduleId());

        assertEquals("flight schedule cancelled successfully", result);
    }
}