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

import com.main.backend.FreshlandDairy.entity.Driver;
import com.main.backend.FreshlandDairy.exception.ResourceNotFoundException;
import com.main.backend.FreshlandDairy.repository.DriverRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDriver(){
		return driverRepository.findAll();
	}
	
	@PostMapping("/drivers")
	public Driver createDriver(@RequestBody Driver driver) {
		return driverRepository.save(driver);
	}
	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
	
		Driver driver = driverRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Driver not exist with id :" + id));
		return ResponseEntity.ok(driver);
	}
	
	@PutMapping("/drivers/{id}")
	public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driverDetails){
		Driver driver = driverRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Driver not exist with id :" + id));
		
		driver.setDfirstName(driverDetails.getDfirstName());
		driver.setLicense(driverDetails.getLicense());
		driver.setEmail(driverDetails.getEmail());
		
		Driver updatedDriver = driverRepository.save(driver);
		return ResponseEntity.ok(updatedDriver);
	}
	
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Driver driver = driverRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Driver not exist with id :" + id));
		
		driverRepository.delete(driver);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
