package com.hexaware.casestudy.simplyfly.mapper;

import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.aircraft_model.AircraftModelResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;

public class AircraftModelMapper {

	public static AircraftModelResponseDto aircraftModelToAircraftModelResponseDto(AircraftModel aircraftModel) {
		
		if(aircraftModel == null)return null;
		
		AircraftModelResponseDto dto = new AircraftModelResponseDto();
		dto.setId(aircraftModel.getId());
		dto.setModelName(aircraftModel.getModelName());
		dto.setManufacturer(aircraftModel.getManufacturer());
		dto.setTotalRows(aircraftModel.getTotalRows());
		dto.setLayoutDescription(aircraftModel.getLayoutDescription());
		
		return dto;
	}
	
	public static AircraftModel aircraftModelAddingRequestDtoToAircraftModel(AircraftModelAddingRequestDto dto) {
		
		if(dto == null)return null;
		
		AircraftModel entity = new AircraftModel();
		entity.setModelName(dto.getModelName());
		entity.setManufacturer(dto.getManufacturer());
		entity.setTotalRows(dto.getTotalRows());
		entity.setLayoutDescription(dto.getLayoutDescription());
		
		return entity;
	}
}
