package com.main.backend.FreshlandDairy.controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.backend.FreshlandDairy.entity.Vehicle;
import com.main.backend.FreshlandDairy.exception.ResourceNotFoundException;
import com.main.backend.FreshlandDairy.repository.VehicleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//get all vehicle
	@GetMapping("/vehicle")
	public List<Vehicle> getAllVehicle(){
		return vehicleRepository.findAll();
	}
	
	//create employee rest api
	@PostMapping("/vehicle")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
			return vehicleRepository.save(vehicle);
		}
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
	
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
		return ResponseEntity.ok(vehicle);
	}
	
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails){
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
		
		vehicle.setReg_number(vehicleDetails.getReg_number());
		vehicle.setVeh_modle(vehicleDetails.getVeh_modle());
		vehicle.setVeh_category(vehicleDetails.getVeh_category());
		vehicle.setYear(vehicleDetails.getYear());
		vehicle.setDeparment(vehicleDetails.getDeparment());
		
		Vehicle updateVehicle = vehicleRepository.save(vehicle);
		return ResponseEntity.ok(updateVehicle);
	}
	
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable Long id){
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
		
		vehicleRepository.delete(vehicle);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
 
	
}
