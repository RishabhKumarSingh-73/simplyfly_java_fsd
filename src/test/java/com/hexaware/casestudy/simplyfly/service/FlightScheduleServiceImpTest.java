package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.dto.FlightScheduleCreateDTO;
import com.hexaware.casestudy.simplyfly.dto.FlightSchedulePriceDTO;
import com.hexaware.casestudy.simplyfly.dto.FlightScheduleResponseDTO;
import com.hexaware.casestudy.simplyfly.entity.FlightSchedule;
import com.hexaware.casestudy.simplyfly.enums.FlightScheduleStatus;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FlightScheduleServiceImpTest {

    @Autowired
    private FlightScheduleServiceImp service;

    private FlightScheduleResponseDTO createSchedule() throws Exception {

        FlightScheduleCreateDTO dto = new FlightScheduleCreateDTO();

        dto.setFlightId(1);
        dto.setRouteId(1);
        dto.setDepartureDatetime(LocalDateTime.now().plusDays(1));
        dto.setArrivalDatetime(LocalDateTime.now().plusDays(1).plusHours(2));

        FlightSchedulePriceDTO price = new FlightSchedulePriceDTO();
        price.setSeatClass(SeatClass.ECONOMY);
        price.setBasePrice(5000.0);

        List<FlightSchedulePriceDTO> prices = new ArrayList<>();
        prices.add(price);

        dto.setPrices(prices);

        return service.addFlightSchedule(dto);
    }

    @Test
    void testGetAllFlightSchedules() throws Exception {

        createSchedule();

        List<FlightSchedule> list = service.getAllFlightSchedules();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetFlightScheduleById() throws Exception {

        FlightScheduleResponseDTO created = createSchedule();

        FlightSchedule schedule = service.getFlightScheduleById(created.getScheduleId());

        assertEquals(created.getScheduleId(), schedule.getId());
    }

    @Test
    void testGetSchedulesByRouteAndDate() throws Exception {

        FlightScheduleResponseDTO created = createSchedule();

        List<FlightSchedule> list =
                service.getSchedulesByRouteAndDate(
                        created.getRouteId(),
                        created.getDepartureDatetime()
                );

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetSchedulesByFlightId() throws Exception {

        FlightScheduleResponseDTO created = createSchedule();

        List<FlightSchedule> list =
                service.getSchedulesByFlightId(created.getFlightId());

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testAddFlightSchedule() throws Exception {

        FlightScheduleResponseDTO response = createSchedule();

        assertNotNull(response);
        assertTrue(response.getScheduleId() > 0);
    }

    @Test
    void testUpdateFlightSchedule() throws Exception {

        FlightScheduleResponseDTO created = createSchedule();

        FlightSchedule updated =
                service.updateFlightScheduleStatus(
                        created.getScheduleId(),
                        FlightScheduleStatus.DELAYED
                );

        assertEquals(FlightScheduleStatus.DELAYED, updated.getStatus());
    }

    @Test
    void testCancelFlightSchedule() throws Exception {

        FlightScheduleResponseDTO created = createSchedule();

        String result = service.cancelFlightSchedule(created.getScheduleId());

        assertEquals("flight schedule cancelled successfully", result);
    }
}