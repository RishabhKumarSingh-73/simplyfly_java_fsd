package com.hexaware.casestudy.simplyfly.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;

@SpringBootTest
class AircraftModelServiceImpTest {

    @Autowired
    private AircraftModelServiceImp service;

    @Autowired
    private AircraftModelRepository repository;

    private AircraftModel createAircraftModelRecord() {

        AircraftModel model = new AircraftModel();
        model.setModelName("A320");
        model.setManufacturer("Airbus");
        model.setTotalRows(30);
        model.setLayoutDescription("3-3");

        return repository.save(model);
    }

    @Test
    void testGetAllAircraftModels() {

        createAircraftModelRecord();

        List<AircraftModelResponseDto> list = service.getAllAircraftModels();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetAircraftModelById() throws AircraftModelNotFoundException {

        AircraftModel saved = createAircraftModelRecord();

        AircraftModelResponseDto response = service.getAircraftModelById(saved.getId());

        assertEquals(saved.getId(), response.getId());
    }

    @Test
    void testGetAircraftModelByName() throws AircraftModelNotFoundException {

        AircraftModel saved = createAircraftModelRecord();

        AircraftModelResponseDto response = service.getAircraftModelByName(saved.getModelName());

        assertEquals(saved.getModelName(), response.getModelName());
    }

    @Test
    void testAddAircraftModel() {

        AircraftModelAddingRequestDto dto = new AircraftModelAddingRequestDto();
        dto.setModelName("B737");
        dto.setManufacturer("Boeing");
        dto.setTotalRows(28);
        dto.setLayoutDescription("3-3");

        AircraftModelResponseDto response = service.addAircraftModel(dto);

        assertNotNull(response);
        assertEquals("B737", response.getModelName());
    }

    @Test
    void testUpdateAircraftModelManufacturer() throws AircraftModelNotFoundException {

        AircraftModel saved = createAircraftModelRecord();

        AircraftModelResponseDto updated =
                service.updateAircraftModelManufacturer("UpdatedManufacturer", saved.getId());

        assertEquals("UpdatedManufacturer", updated.getManufacturer());
    }

    @Test
    void testDeleteAircraftModelById() throws AircraftModelNotFoundException, ServiceNotAllowedException {

        AircraftModel saved = createAircraftModelRecord();

        String result = service.deleteAircraftModelById(saved.getId());

        assertEquals("record deleted successfully", result);
    }
}