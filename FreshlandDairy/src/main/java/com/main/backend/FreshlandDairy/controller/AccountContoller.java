package com.main.backend.FreshlandDairy.controller;
//import java.util.Date;
import java.util.HashMap;
import com.main.backend.FreshlandDairy.repository.*;
import com.main.backend.FreshlandDairy.jwt.resource.*;
import com.main.backend.FreshlandDairy.entity.*;
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


@CrossOrigin(origins="http://localhost:4200")


@RestController
@RequestMapping("/users/accounts")
public class AccountContoller {
	@Autowired
	public AccountRepositary accountripositary;
	
	@GetMapping("")
	public List <Account> getAllAccounts() {
		return accountripositary.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Account> getAccount(@PathVariable long id) {
		Account account = accountripositary.findById(id).orElseThrow(() -> new AccountExeption("account not found"));
		return ResponseEntity.ok(account);
	}
	
	@PostMapping("")
	public Account createBill ( @RequestBody Account account){
		return accountripositary.save(account);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteAccount (@PathVariable long id){
		Account existinAccount = accountripositary.findById(id).orElseThrow(() -> new AccountExeption("user not found"));
		accountripositary.delete(existinAccount);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Account> updateAccount (@PathVariable long id, @RequestBody Account account){
		Account existinAccount = accountripositary.findById(id).orElseThrow(() -> new AccountExeption("user not found"));
		
		existinAccount.setMonth(account.getMonth());
		existinAccount.setAmount(account.getAmount());
		existinAccount.setYear(account.getYear());
		existinAccount.setDepartment(account.getDepartment());
		existinAccount.setAccountType(account.getAccountType());
		Account updated = accountripositary.save(existinAccount);
		return ResponseEntity.ok(updated);
		
	}
	
	/*
	@GetMapping("/datesearch/{month}/{year}")
	public List <Account> searchbydate(@PathVariable String month, @PathVariable Long year) {
		
		return accountripositary.findBydate(month, year);
	}
	
	@GetMapping("/getsum/{month}/{year}")
	public Double getSum(@PathVariable String month, @PathVariable Long year) {
		return accountripositary.getSum(month, year);
	}*/
	@GetMapping("/getreportobjects/{accountType}/{month}/{year}")
	public List <Account> searchbydate(@PathVariable String accountType, @PathVariable String month, @PathVariable Long year) {
		//return accountripositary.findBydate(month, year);
		return accountripositary.findBydate(accountType, month, year);
	}
	
	@GetMapping("/getreportsums/{accountType}/{month}/{year}")
	public double getSum(@PathVariable String accountType, @PathVariable String month, @PathVariable Long year) {
		//return accountripositary.getSum(month, year);
		return accountripositary.getSum(accountType, month, year);
	}
}
