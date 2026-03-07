package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;

public interface IAircraftModelService {
	List<AircraftModel> getAllAircraftModels();
    AircraftModel getAircraftModelById(int id)throws AircraftModelNotFoundException;
    AircraftModel getAircraftModelByName(String modelName)throws AircraftModelNotFoundException;
    AircraftModel addAircraftModel(AircraftModel aircraftModel);
    AircraftModel updateAircraftModel(AircraftModel aircraftModel)throws AircraftModelNotFoundException;
    String deleteAircraftModelById(int id)throws AircraftModelNotFoundException;
}
