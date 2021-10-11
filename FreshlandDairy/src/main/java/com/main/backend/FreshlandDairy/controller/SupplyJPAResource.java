package com.main.backend.FreshlandDairy.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.backend.FreshlandDairy.entity.Supply;
import com.main.backend.FreshlandDairy.repository.SupplyJPARepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SupplyJPAResource {
	
	@Autowired
	private SupplyJPARepository supplyJPARepository;
	
	//GET/retrieve
	
	@GetMapping("/jpa/users/{username}/Supplyy")
	public List<Supply> getAllSupply(@PathVariable String username) throws InterruptedException{
		return supplyJPARepository.findAll();
		//return todoService.findAll();
	}
	
	@GetMapping("/jpa/users/{username}/Supplyy/{sid}")
	public Supply getSupply(@PathVariable String username, @PathVariable long sid) {
		return supplyJPARepository.findById(sid).get();
		//return todoService.findById(id);
	}
	
	//DELETE
	
	@DeleteMapping("/jpa/users/{username}/Supplyy/{sid}")
	public ResponseEntity<Void> deleteSupply(@PathVariable String username, @PathVariable long sid){
		
		supplyJPARepository.deleteById(sid);
		
			return ResponseEntity.noContent().build();
		
	}
	
	//UPDATE
	
	@PutMapping("/jpa/users/{username}/Supplyy/{sid}")
	public ResponseEntity<Supply> updateSupply(
			@PathVariable String username, @PathVariable long sid, @RequestBody Supply supply){
		
		supply.setUsername(username);
		Supply SupplyUpdated = supplyJPARepository.save(supply);
		return new ResponseEntity<Supply>(supply, HttpStatus.OK);
	}
	
	//CREATE
	
	@PostMapping("/jpa/users/{username}/Supplyy")
	public ResponseEntity<Void> createSupply(@PathVariable String username, @RequestBody Supply supply){
		
		supply.setUsername(username);
		Supply createdSupply = supplyJPARepository.save(supply);
		
		//get current resource url - location
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{sid}").buildAndExpand(createdSupply.getSid()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	

}
