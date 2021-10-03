package com.main.backend.FreshlandDairy.controller;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

//import javax.persistence.Column;

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


import com.main.backend.FreshlandDairy.repository.*;
import com.main.backend.FreshlandDairy.jwt.resource.*;
import com.main.backend.FreshlandDairy.entity.*;


@CrossOrigin(origins="http://localhost:4200")


@RestController
@RequestMapping("/users/salary")
public class SalaryController {
	@Autowired
	public SalaryRepositary salaryripositary;
	
	@GetMapping("")
	public List <Salary> getAllSalarys() {
		return salaryripositary.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Salary> getSalary(@PathVariable long id) {
		Salary salary = salaryripositary.findById(id).orElseThrow(() -> new SalaryExeption("salary record not found"));
		return ResponseEntity.ok(salary);
	}
	
	@PostMapping("")
	public Salary createSalary ( @RequestBody Salary salary){
		return salaryripositary.save(salary);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteSalary (@PathVariable long id){
		Salary existinSalary = salaryripositary.findById(id).orElseThrow(() -> new SalaryExeption("salary record not found"));
		salaryripositary.delete(existinSalary);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Salary> updatSalary (@PathVariable long id, @RequestBody Salary salary){
		Salary existinSalary = salaryripositary.findById(id).orElseThrow(() -> new SalaryExeption("user not found"));
		existinSalary.setEid(salary.getEid());
		existinSalary.setMonth(salary.getMonth());
		existinSalary.setYear(salary.getYear());
		existinSalary.setJob(salary.getJob());
		existinSalary.setBasic(salary.getBasic());
		existinSalary.setBonus(salary.getBonus());
		existinSalary.setOt(salary.getOt());
		existinSalary.setEtf(salary.getEtf());
		existinSalary.setEpf(salary.getEpf());
		existinSalary.setTotal(salary.getTotal());
		Salary updated = salaryripositary.save(existinSalary);
		return ResponseEntity.ok(updated);
		
	}
	
}
