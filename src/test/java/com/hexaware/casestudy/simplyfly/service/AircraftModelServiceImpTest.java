package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class AircraftModelServiceImpTest {

    @Autowired
    private AircraftModelServiceImp service;

    @Test
    void testAddAircraftModel() {

        AircraftModel model = new AircraftModel();
        model.setModelName("A320");
        model.setManufacturer("Airbus");
        model.setTotalRows(30);
        model.setLayoutDescription("3-3");

        AircraftModel saved = service.addAircraftModel(model);

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void testGetAllAircraftModels() {

        AircraftModel model = new AircraftModel();
        model.setModelName("B737");
        model.setManufacturer("Boeing");
        model.setTotalRows(28);
        model.setLayoutDescription("3-3");

        service.addAircraftModel(model);

        List<AircraftModel> list = service.getAllAircraftModels();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetAircraftModelById() throws AircraftModelNotFoundException {

        AircraftModel model = new AircraftModel();
        model.setModelName("A321");
        model.setManufacturer("Airbus");
        model.setTotalRows(32);
        model.setLayoutDescription("3-3");

        AircraftModel saved = service.addAircraftModel(model);

        AircraftModel found = service.getAircraftModelById(saved.getId());

        assertEquals(saved.getId(), found.getId());
    }

    @Test
    void testGetAircraftModelByName() throws AircraftModelNotFoundException {

        AircraftModel model = new AircraftModel();
        model.setModelName("A319");
        model.setManufacturer("Airbus");
        model.setTotalRows(25);
        model.setLayoutDescription("3-3");

        service.addAircraftModel(model);

        AircraftModel found = service.getAircraftModelByName("A319");

        assertEquals("A319", found.getModelName());
    }

    @Test
    void testUpdateAircraftModel() throws AircraftModelNotFoundException {

        AircraftModel model = new AircraftModel();
        model.setModelName("B777");
        model.setManufacturer("Boeing");
        model.setTotalRows(40);
        model.setLayoutDescription("3-4-3");

        AircraftModel saved = service.addAircraftModel(model);

        saved.setManufacturer("Updated Boeing");

        AircraftModel updated = service.updateAircraftModel(saved);

        assertEquals("Updated Boeing", updated.getManufacturer());
    }

    @Test
    void testDeleteAircraftModelById() throws AircraftModelNotFoundException {

        AircraftModel model = new AircraftModel();
        model.setModelName("A350");
        model.setManufacturer("Airbus");
        model.setTotalRows(38);
        model.setLayoutDescription("3-3-3");

        AircraftModel saved = service.addAircraftModel(model);

        String result = service.deleteAircraftModelById(saved.getId());

        assertEquals("record deleted successfully", result);
    }
}