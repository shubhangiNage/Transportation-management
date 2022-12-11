package com.cjc.project.Homeloan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.Enquiry;
import com.cjc.project.Homeloan.service.EnquiryService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EnquiryController {
	@Autowired
	EnquiryService es;
	
	
	@PostMapping("/saveEnq")
	public  ResponseEntity< Enquiry> saveEnquiry(@RequestBody Enquiry e) {
		
	Enquiry ee=	es.saveEnquiry(e);
	return new ResponseEntity<Enquiry>(ee,HttpStatus.CREATED);
			
	}
	
	@GetMapping("/getCustDetails")
	public ResponseEntity<List<Enquiry>>  getAllDetails(){
		
		List<Enquiry> list=es.getAllDetails();
		
		
		
		return new ResponseEntity<List<Enquiry>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/singlecustenqdetail/{cid}")
	public ResponseEntity<Optional<Enquiry>> getSingleDataenq(@PathVariable("cid") Integer cid) {
		   Optional<Enquiry> enq=es.getSingleDataenq(cid);
		   if(enq.isPresent())
		   {
			   
			   return new ResponseEntity<Optional<Enquiry>>(enq,HttpStatus.OK);
		   }
		return null;
	}
	
	@PutMapping("/updateenqdetail/{cid}")
	public ResponseEntity<Enquiry>  updateenqdetail(@RequestBody Enquiry e,@PathVariable("cid") Integer cid)
	{      
		Optional<Enquiry> eqy =es.getSingleDataenq(cid);
		if(eqy.isPresent())
		{
		  Enquiry en= es.saveEnquiry(e);
		return new ResponseEntity<Enquiry>(en,HttpStatus.OK);
		}
		return null;
	}
	
	
	@GetMapping("/cibilStatus/{cid}")
	public String checkCibilStatus(@PathVariable ("cid") Integer cid) 
	{
		
		
		
		Integer  in=es.checkCibil(cid);
		
		
		return  "in";
		
		
		
	}
	
	
	


}
