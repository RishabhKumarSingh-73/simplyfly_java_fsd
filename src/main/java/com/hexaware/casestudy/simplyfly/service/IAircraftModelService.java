package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelResponseDto;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;

public interface IAircraftModelService {
	List<AircraftModelResponseDto> getAllAircraftModels();
	AircraftModelResponseDto getAircraftModelById(int id)throws AircraftModelNotFoundException;
	AircraftModelResponseDto getAircraftModelByName(String modelName)throws AircraftModelNotFoundException;
	AircraftModelResponseDto addAircraftModel(AircraftModelAddingRequestDto aircraftModelDto);
	AircraftModelResponseDto updateAircraftModelManufacturer(String manufacturer, int id)throws AircraftModelNotFoundException;
    String deleteAircraftModelById(int id)throws AircraftModelNotFoundException,ServiceNotAllowedException;
}
