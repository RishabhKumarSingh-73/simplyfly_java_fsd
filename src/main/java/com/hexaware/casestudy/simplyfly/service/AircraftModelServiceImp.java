package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AircraftModelServiceImp implements IAircraftModelService {
	
	@Autowired
	private AircraftModelRepository repository;

	@Override
	public List<AircraftModel> getAllAircraftModels() {
		
		return repository.findAll();
		
	}

	@Override
	public AircraftModel getAircraftModelById(int id) throws AircraftModelNotFoundException{
		
		return repository.findById(id).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
	}

	@Override
	public AircraftModel getAircraftModelByName(String modelName) throws AircraftModelNotFoundException{
		
		return repository.findByModelName(modelName).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
	}

	@Override
	public AircraftModel addAircraftModel(AircraftModel aircraftModel) {
		
		return repository.save(aircraftModel);
		
	}

	@Override
	public AircraftModel updateAircraftModel(AircraftModel aircraftModel) throws AircraftModelNotFoundException{
		
		repository.findById(aircraftModel.getId()).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
		return repository.save(aircraftModel);
		
	}

	@Override
	public String deleteAircraftModelById(int id) throws AircraftModelNotFoundException{
		
		AircraftModel aircraftModel = repository.findById(id).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
		repository.delete(aircraftModel);
		
		return "record deleted successfully";
		
	}

}
