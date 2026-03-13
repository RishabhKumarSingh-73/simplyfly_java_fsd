package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.mapper.AircraftModelMapper;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;
import com.hexaware.casestudy.simplyfly.repository.FlightRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AircraftModelServiceImp implements IAircraftModelService {
	
	@Autowired
	private AircraftModelRepository repository;
	
	@Autowired
	private FlightRepository flightRepo;

	@Override
	public List<AircraftModelResponseDto> getAllAircraftModels() {
		
		return repository.findAll().stream().map(entity->{
			return AircraftModelMapper.aircraftModelToAircraftModelResponseDto(entity);
		}).toList();
		
	}

	@Override
	public AircraftModelResponseDto getAircraftModelById(int id) throws AircraftModelNotFoundException{
		
		AircraftModel aircraftModel = repository.findById(id).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
		return AircraftModelMapper.aircraftModelToAircraftModelResponseDto(aircraftModel);
		
	}

	@Override
	public AircraftModelResponseDto getAircraftModelByName(String modelName) throws AircraftModelNotFoundException{
		
		AircraftModel aircraftModel = repository.findByModelName(modelName).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
		return AircraftModelMapper.aircraftModelToAircraftModelResponseDto(aircraftModel);
		
	}

	@Override
	public AircraftModelResponseDto addAircraftModel(AircraftModelAddingRequestDto aircraftModelDto) {
		
		AircraftModel aircraftModel = AircraftModelMapper.aircraftModelAddingRequestDtoToAircraftModel(aircraftModelDto);
		
		return AircraftModelMapper.aircraftModelToAircraftModelResponseDto(repository.save(aircraftModel));
		
	}

	@Override
	public AircraftModelResponseDto updateAircraftModelManufacturer(String manufacturer, int id) throws AircraftModelNotFoundException{
		
		AircraftModel aircraftModel = repository.findById(id).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
		aircraftModel.setManufacturer(manufacturer);
		
		return AircraftModelMapper.aircraftModelToAircraftModelResponseDto(repository.save(aircraftModel));
		
	}

	@Override
	public String deleteAircraftModelById(int id) throws AircraftModelNotFoundException,ServiceNotAllowedException{
		
		AircraftModel aircraftModel = repository.findById(id).orElseThrow(()->new AircraftModelNotFoundException("Aircraft Model not found"));
		
		if(flightRepo.findByAircraftModel_Id(id).size() > 0)throw new ServiceNotAllowedException("Cant delete aircraft model with existing Flights");
		
		repository.delete(aircraftModel);
		
		return "record deleted successfully";
		
	}

}
