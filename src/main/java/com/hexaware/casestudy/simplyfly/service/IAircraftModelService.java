package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;

public interface IAircraftModelService {
	List<AircraftModel> getAllAircraftModels();
    AircraftModel getAircraftModelById(int id);
    AircraftModel getAircraftModelByName(String modelName);
    int addAircraftModel(AircraftModel aircraftModel);
    int updateAircraftModel(AircraftModel aircraftModel);
    int deleteAircraftModelById(int id);
}
