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

import com.main.backend.FreshlandDairy.entity.StockDetails;
import com.main.backend.FreshlandDairy.exception.StockDetailExeption;
import com.main.backend.FreshlandDairy.repository.StockDetialRepositary;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/users")
public class StockdetailContoller {
	
	@Autowired
	public StockDetialRepositary rawRipo;
	
	@GetMapping("/stockmanagement")
	public List <StockDetails> getAllMatirials() {
		return rawRipo.findAll();
	}
	
	@GetMapping("/stockmanagement/{id}")
	public ResponseEntity <StockDetails> getMatirials(@PathVariable long id) {
		StockDetails Matirial = rawRipo.findById(id).orElseThrow(() -> new StockDetailExeption("user not found"));
		return ResponseEntity.ok(Matirial);
	}
	
	@PostMapping("/stockmanagement")
	public StockDetails createRawMaterial(@RequestBody StockDetails smaterial) {
		return rawRipo.save(smaterial);
		
	}
	
	@DeleteMapping("/stockmanagement/{id}")
	public ResponseEntity <Map<String, Boolean>> deleterawmaterial (@PathVariable long id){
		
		StockDetails Matirial = rawRipo.findById(id).orElseThrow(() -> new StockDetailExeption("user not found"));
		
		rawRipo.delete(Matirial);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/stockmanagement/{id}")
	public ResponseEntity <StockDetails> updateMatirials(@PathVariable long id, @RequestBody StockDetails pmaterial) {
		StockDetails Matirial = rawRipo.findById(id).orElseThrow(() -> new StockDetailExeption("user not found"));

		Matirial.setSID(pmaterial.getSID());
		Matirial.setName(pmaterial.getName());
		Matirial.setDiscription(pmaterial.getDiscription());
		Matirial.setPrice(pmaterial.getPrice());
		Matirial.setWight(pmaterial.getWight());
		Matirial.setArrQty(pmaterial.getArrQty());
		Matirial.setReQty(pmaterial.getArrQty());
		Matirial.setDate(pmaterial.getDate());
		StockDetails updated = rawRipo.save(Matirial);
		return ResponseEntity.ok(updated);
	}
	
	@GetMapping("/stockmanagement/search/{searchTerm}")
	public List <StockDetails> search(@PathVariable String searchTerm) {
		
        
		return rawRipo.findBySearchTerm(searchTerm);
	}

}
