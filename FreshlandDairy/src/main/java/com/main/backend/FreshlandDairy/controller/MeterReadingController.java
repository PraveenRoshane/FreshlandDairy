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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.backend.FreshlandDairy.entity.MeterReading;
import com.main.backend.FreshlandDairy.exception.ResourceNotFoundException;
import com.main.backend.FreshlandDairy.repository.MeterReadingsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MeterReadingController {
	
	@Autowired
	private MeterReadingsRepository meterReadingsRepository;
	
	@GetMapping("/read")
	public List<MeterReading> getAllVehicle(){
		return meterReadingsRepository.findAll();
	}
	
	@DeleteMapping("/read/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRead(@PathVariable Long id){
		MeterReading meterReading = meterReadingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle not exist with id :" + id));
		
		meterReadingsRepository.delete(meterReading);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/read")
	public MeterReading createRead(@RequestBody MeterReading meterReading) {
			return meterReadingsRepository.save(meterReading);
		}
}
