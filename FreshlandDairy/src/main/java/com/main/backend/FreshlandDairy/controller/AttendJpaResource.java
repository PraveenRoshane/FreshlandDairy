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

import com.main.backend.FreshlandDairy.entity.Attend;
import com.main.backend.FreshlandDairy.repository.AttendJpaRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AttendJpaResource {
	
//	@Autowired
//	private MyAppHardcodedService myappService;
	//change
	@Autowired
	private AttendJpaRepository attendJpaRepository;
	
	@GetMapping("/jpa/users/{username}/Attendlist")
	public List<Attend> getAllDetails(@PathVariable String username) //throws InterruptedException
	{
		return attendJpaRepository.findByUsername(username);
		//return myappService.findAll();
	}
	
	@GetMapping("/jpa/users/{username}/Attendlist/{aid}")
	public Attend getDetails(@PathVariable String username, @PathVariable long aid) //throws InterruptedException
	{
		return attendJpaRepository.findById(aid).get();
		//return myappService.findById(id);
	}
	
	@DeleteMapping("/jpa/users/{username}/Attendlist/{aid}")
	public ResponseEntity <Void> deleteAttend
	(@PathVariable String username, @PathVariable long aid){
		 
		attendJpaRepository.deleteById(aid); 
		
			return ResponseEntity.noContent().build(); 
			//normally delete method dont return content when succesful
		
	}
	
	@PutMapping("/jpa/users/{username}/Attendlist/{aid}")
	public ResponseEntity<Attend> UpdateAttend(
			@PathVariable String username,
			@PathVariable long aid, @RequestBody Attend attend){
		
		attend.setUsername(username);
		
		Attend attendUpdated = attendJpaRepository.save(attend);
		
		return new ResponseEntity<Attend>(attend, HttpStatus.OK);
		
		//return status with oK and updated values
		
	}
	
	@PostMapping("/jpa/users/{username}/Attendlist")
	public ResponseEntity<Void> createAttend(
			@PathVariable String username, @RequestBody Attend attend){
		
		attend.setUsername(username);
		Attend createdAttend = attendJpaRepository.save(attend);
		

		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{aid}").
		buildAndExpand(createdAttend.getAid()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	

}
