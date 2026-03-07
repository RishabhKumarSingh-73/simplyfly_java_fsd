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

@Entity
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
	 
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getModelName() {
		 return modelName;
	 }
	 public void setModelName(String modelName) {
		 this.modelName = modelName;
	 }
	 public String getManufacturer() {
		 return manufacturer;
	 }
	 public void setManufacturer(String manufacturer) {
		 this.manufacturer = manufacturer;
	 }
	 public int getTotalRows() {
		 return totalRows;
	 }
	 public void setTotalRows(int totalRows) {
		 this.totalRows = totalRows;
	 }
	 public String getLayoutDescription() {
		 return layoutDescription;
	 }
	 public void setLayoutDescription(String layoutDescription) {
		 this.layoutDescription = layoutDescription;
	 }
	 public AircraftModel(int id, String modelName, String manufacturer, int totalRows, String layoutDescription) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.manufacturer = manufacturer;
		this.totalRows = totalRows;
		this.layoutDescription = layoutDescription;
	 }
	 
	 public AircraftModel() {
		 
	 }
	 
}
