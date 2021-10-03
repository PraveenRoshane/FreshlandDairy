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
import com.main.backend.FreshlandDairy.repository.*;
import com.main.backend.FreshlandDairy.jwt.resource.*;
import com.main.backend.FreshlandDairy.entity.*;



@CrossOrigin(origins="http://localhost:4200")


@RestController
@RequestMapping("/users")
public class FmBillController {
	
	@Autowired
	public FmBillRepositary billrepositary;
	
	
	
	@GetMapping("/bills")
	public List <FmBillDetails> getAllBills() {
		return billrepositary.findAll();
	}
	
	@GetMapping("/bills/{id}")
	public ResponseEntity <FmBillDetails> getBill(@PathVariable long id) {
		FmBillDetails bill = billrepositary.findById(id).orElseThrow(() -> new FmBillExeption("user not found"));
		return ResponseEntity.ok(bill);
	}
	
	
	
	
	@PostMapping("/bills")
	public FmBillDetails createBill ( @RequestBody FmBillDetails bill){
	//public ResponseEntity <Void> createBill ( @RequestBody Bill bill){	
		
		return billrepositary.save(bill);
		
	}
	
	
	
	@DeleteMapping("/bills/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteBill (@PathVariable long id){
		
		FmBillDetails existinBill = billrepositary.findById(id).orElseThrow(() -> new FmBillExeption("user not found"));
		
		billrepositary.delete(existinBill);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	 
	
	
	
	@PutMapping("/bills/{id}")
	public ResponseEntity <FmBillDetails> updateBill (@PathVariable long id, @RequestBody FmBillDetails bill){
		//Bill billupdated = billrepositary.save(bill);
		//return new ResponseEntity <Bill> (bill, HttpStatus.OK);
		FmBillDetails existinBill = billrepositary.findById(id).orElseThrow(() -> new FmBillExeption("user not found"));
		
		existinBill.setDiscription(bill.getDiscription());
		existinBill.setAmount(bill.getAmount());
		existinBill.setBillDate(bill.getBillDate());
		existinBill.setBillType(bill.getBillType());
		FmBillDetails updated = billrepositary.save(existinBill);
		return ResponseEntity.ok(updated);
	}
	

}
