package com.hexaware.casestudy.simplyfly.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AircraftModel {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 private String modelName;
	 private String manufacturer;
	 private int totalRows;
	 private String layoutDescription;
	 
	 @OneToMany(mappedBy = "aircraftModel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private List<Seat> seats = new ArrayList<>();
	 
}
