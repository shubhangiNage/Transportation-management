package com.cjc.project.Homeloan.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.project.Homeloan.model.Ledger;
import com.cjc.project.Homeloan.service.EnquiryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ledger")
public class LedgerController {
	
	@Autowired
	EnquiryService esledger;
	
	@PostMapping("/setledger")
	public ResponseEntity<Ledger> setledgerdeail(@RequestBody Ledger ledger)
	{
		Ledger ld= esledger.setledgerdeail(ledger);

		return new ResponseEntity<Ledger>(ld,HttpStatus.CREATED);
		
		
	}
	 @GetMapping("/getledgers")
	 public ResponseEntity<List<Ledger>> getledgerdetails()
	 {
		 List<Ledger> ledlist=esledger.getledgerdetails();
		return new ResponseEntity<List<Ledger>>(ledlist,HttpStatus.OK);
		 
	 }
	 
	 
	 @DeleteMapping("/deleteLeadger/{id}")
	 public String  deleteData(@PathVariable Integer id) {
		 
		 
		 
		 esledger.deleteLeadger(id);
		 
		 
		 
		 return "Deleted";
		 
	 }
	 
	 @PutMapping("/updateLedger/{id}")
	 public Ledger  updateLeadger(@RequestBody Ledger l,@PathVariable Integer id) {
		 
		 
		 l.setLedgerId(id);
		 
		 Ledger ll=esledger.UpdateLeadger(l);
		 
		return ll;
		 
		 
		 
		 
		 
	 }
}
