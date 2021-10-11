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

import com.main.backend.FreshlandDairy.entity.Supplier;
import com.main.backend.FreshlandDairy.repository.SupplierJPARepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SupplierJPAResource {
		
	@Autowired
	private SupplierJPARepository supplierJPARepository;
	
	//GET/retrieve
	
	@GetMapping("/jpa/users/{username}/Suppliers")
	public List<Supplier> getAllSuppliers(@PathVariable String username) throws InterruptedException{
		return supplierJPARepository.findAll();
		//return todoService.findAll();
	}
	
	@GetMapping("/jpa/users/{username}/Suppliers/{id}")
	public Supplier getSuppliers(@PathVariable String username, @PathVariable long id) {
		return supplierJPARepository.findById(id).get();
		//return todoService.findById(id);
	}
	
	//DELETE
	
	@DeleteMapping("/jpa/users/{username}/Suppliers/{id}")
	public ResponseEntity<Void> deleteSuppliers(@PathVariable String username, @PathVariable long id){
		
		supplierJPARepository.deleteById(id);
		
			return ResponseEntity.noContent().build();
		
	}
	
	//UPDATE
	
	@PutMapping("/jpa/users/{username}/Suppliers/{id}")
	public ResponseEntity<Supplier> updateSuppliers(
			@PathVariable String username, @PathVariable long id, @RequestBody Supplier supplier){
		
		supplier.setUsername(username);
		Supplier SuppliersUpdated = supplierJPARepository.save(supplier);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	
	//CREATE
	
	@PostMapping("/jpa/users/{username}/Suppliers")
	public ResponseEntity<Void> createSuppliers(@PathVariable String username, @RequestBody Supplier supplier){
		
		supplier.setUsername(username);
		Supplier createdSuppliers = supplierJPARepository.save(supplier);
		
		//get current resource url - location
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSuppliers.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
}
