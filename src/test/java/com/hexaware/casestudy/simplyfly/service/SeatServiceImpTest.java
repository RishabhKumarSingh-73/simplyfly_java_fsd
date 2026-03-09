package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.enums.SeatClass;
import com.hexaware.casestudy.simplyfly.enums.SeatPosition;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.SeatRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class SeatServiceImpTest {

    @Autowired
    private SeatServiceImp service;

    @Autowired
    private SeatRepository repository;

    private Seat createSeatRecord() {

        AircraftModel model = new AircraftModel();
        model.setId(1);

        Seat seat = new Seat();
        seat.setAircraftModel(model);
        seat.setRowNumber(1);
        seat.setColumnLetter('A');
        seat.setSeatClass(SeatClass.ECONOMY);
        seat.setPositionType(SeatPosition.WINDOW);

        return repository.save(seat);
    }

    @Test
    void testGetSeatsByAircraftModelId() {

        createSeatRecord();

        List<Seat> list = service.getSeatsByAircraftModelId(1);

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetSeatById() throws SeatNotFoundException {

        Seat saved = createSeatRecord();

        Seat seat = service.getSeatById(saved.getId());

        assertEquals(saved.getId(), seat.getId());
    }

    @Test
    void testAddSeat() {

        Seat saved = createSeatRecord();

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testUpdateSeat() throws SeatNotFoundException {

        Seat saved = createSeatRecord();

        saved.setRowNumber(1);
        saved.setColumnLetter('B');

        Seat updated = service.updateSeat(saved);

        assertEquals("1B", updated.getRowNumber()+updated.getColumnLetter());
    }

    @Test
    void testDeleteSeatById() throws SeatNotFoundException {

        Seat saved = createSeatRecord();

        String result = service.deleteSeatById(saved.getId());

        assertEquals("Seat record deleted successfully", result);
    }
}