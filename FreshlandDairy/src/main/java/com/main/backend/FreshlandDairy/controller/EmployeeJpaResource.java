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

import com.main.backend.FreshlandDairy.entity.MyApp;
import com.main.backend.FreshlandDairy.repository.MyAppJpaRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeJpaResource {
		
		@Autowired //matching repository
		private MyAppJpaRepository myappJpaRepository;
	
		
		//retrive all
		@GetMapping("/jpa/users/{username}/MyApplist")
		public List<MyApp> getAllDetails(@PathVariable String username) //throws InterruptedException
		{
			return myappJpaRepository.findByUsername(username);
			//return myappService.findAll();
		}
		
		//retrive by id
		@GetMapping("/jpa/users/{username}/MyApplist/{id}")
		public MyApp getDetails(@PathVariable String username, @PathVariable long id) //throws InterruptedException
		{
			return myappJpaRepository.findById(id).get();
			//return myappService.findById(id);
		}
		
		//delete users url
		//DELETE /users/{username}/MyApplist/{id}
		
		@DeleteMapping("/jpa/users/{username}/MyApplist/{id}")
		public ResponseEntity <Void> deleteMyApp
		(@PathVariable String username, @PathVariable long id){
			 
			myappJpaRepository.deleteById(id); 
			
				return ResponseEntity.noContent().build(); 
				//normally delete method dont return content when successful
			
		}
		
		//Update a myapplist
		// PUT /users/{username}/MyApplist/{MyApp_id}
		
		@PutMapping("/jpa/users/{username}/MyApplist/{id}")
		public ResponseEntity<MyApp> UpdateMyApp(
				@PathVariable String username,
				@PathVariable long id, @RequestBody MyApp myapp){
			
			myapp.setUsername(username);
			
			MyApp myappUpdated = myappJpaRepository.save(myapp);
			
			return new ResponseEntity<MyApp>(myapp, HttpStatus.OK);
			
			//return status with oK and updated values
			
		}
		
		
		
		
		//Create a new MyApplist
		//POST/users/{username}/MyApplist 
		
		@PostMapping("/jpa/users/{username}/MyApplist")
		public ResponseEntity<Void> createMyApp(
				@PathVariable String username, @RequestBody MyApp myapp){
			
			myapp.setUsername(username);
			MyApp createdMyApp = myappJpaRepository.save(myapp);
			
	
			
			//Location
			//Get current resource url
			///{id}
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
			buildAndExpand(createdMyApp.getId()).toUri();
			
			return ResponseEntity.created(uri).build();
			
		}
		
		
		
		
		
}
 