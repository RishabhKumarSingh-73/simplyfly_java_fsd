package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.entity.FlightSeat;
import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.enums.FlightSeatStatus;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.FlightSeatRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FlightSeatServiceImpTest {

    @Autowired
    private FlightSeatServiceImp service;

    @Autowired
    private FlightSeatRepository repository;

    private FlightSeat createSeatRecord() {

        FlightSchedule schedule = new FlightSchedule();
        schedule.setId(1);

        Seat seat = new Seat();
        seat.setId(1);

        FlightSeat flightSeat = new FlightSeat();
        flightSeat.setFlightSchedule(schedule);
        flightSeat.setSeat(seat);
        flightSeat.setStatus(FlightSeatStatus.AVAILABLE);

        return repository.save(flightSeat);
    }

    @Test
    void testGetSeatsByScheduleId() {

        createSeatRecord();

        List<FlightSeat> list = service.getSeatsByScheduleId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetAvailableSeatsByScheduleId() {

        createSeatRecord();

        List<FlightSeat> list = service.getAvailableSeatsByScheduleId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetFlightSeatById() throws FlightSeatNotFoundException {

        FlightSeat saved = createSeatRecord();

        FlightSeat seat = service.getFlightSeatById(saved.getId());

        assertEquals(saved.getId(), seat.getId());
    }

    @Test
    void testUpdateSeatStatus() throws FlightSeatNotFoundException {

        FlightSeat saved = createSeatRecord();

        FlightSeat updated =
                service.updateSeatStatus(
                        saved.getId(),
                        FlightSeatStatus.BOOKED
                );

        assertEquals(FlightSeatStatus.BOOKED, updated.getStatus());
    }
}