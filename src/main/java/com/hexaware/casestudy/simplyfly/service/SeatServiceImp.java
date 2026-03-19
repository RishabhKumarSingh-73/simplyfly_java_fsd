package com.hexaware.casestudy.simplyfly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.casestudy.simplyfly.dto.seat.SeatAddingRequestDto;
import com.hexaware.casestudy.simplyfly.dto.seat.SeatResponseDto;
import com.hexaware.casestudy.simplyfly.entity.AircraftModel;
import com.hexaware.casestudy.simplyfly.entity.Seat;
import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;
import com.hexaware.casestudy.simplyfly.mapper.SeatMapper;
import com.hexaware.casestudy.simplyfly.repository.AircraftModelRepository;
import com.hexaware.casestudy.simplyfly.repository.SeatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeatServiceImp implements ISeatService {

	@Autowired
	private SeatRepository repository;
	
	@Autowired
	private AircraftModelRepository aircraftModelRepository;
	
	@Override
	public List<SeatResponseDto> getSeatsByAircraftModelId(int aircraftModelId) {
		
		return repository.findByAircraftModel_Id(aircraftModelId).stream().map(entity->{
			return SeatMapper.seatToSeatResponseDto(entity);
		}).toList();
		
	}

	@Override
	public SeatResponseDto getSeatById(int id) throws SeatNotFoundException{

		Seat seat = repository.findById(id).orElseThrow(()->new SeatNotFoundException("Seat record not found"));
		
		return SeatMapper.seatToSeatResponseDto(seat);
	
	}

	@Override
	public SeatResponseDto addSeat(SeatAddingRequestDto seatDto)throws AircraftModelNotFoundException {
		
		AircraftModel model = aircraftModelRepository.findById(seatDto.getAircraftModelId()).orElseThrow(()->new AircraftModelNotFoundException("aircraft model not found"));
		
		Seat seat = SeatMapper.seatAddingRequestDtoToSeat(seatDto,model);
		
		return SeatMapper.seatToSeatResponseDto(repository.save(seat));
	
	}

//	@Override
//	public SeatResponseDto updateSeat(SeatAddingRequestDto seatDto,int id) throws SeatNotFoundException{
//		
//		
//		
//		repository.findById(seat.getId()).orElseThrow(()->new SeatNotFoundException("Seat record not found"));
//		
//		return repository.save(seat);
//	
//	}
//
//	@Override
//	public String deleteSeatById(int id) throws SeatNotFoundException{
//		
//		Seat seat = repository.findById(id).orElseThrow(()->new SeatNotFoundException("Seat record not found"));
//		
//		repository.delete(seat);
//		
//		return "Seat record deleted successfully";
//		
//	}

}
