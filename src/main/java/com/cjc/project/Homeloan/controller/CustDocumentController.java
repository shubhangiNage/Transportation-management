package com.cjc.project.Homeloan.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.CustomerDocument;
import com.cjc.project.Homeloan.model.Emi;
import com.cjc.project.Homeloan.model.Enquiry;
import com.cjc.project.Homeloan.model.Rejectlist;
import com.cjc.project.Homeloan.service.EnquiryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class CustDocumentController {
	
	@Autowired
	EnquiryService esi;
	
	
	
	
	
	
	////************************************************************************all methods***********************************************////
	
	
	
	
	
	@GetMapping("/getsingledata/{id}")
	public Customer singledata(@PathVariable ("id") Integer id) {
		
	Customer cu=esi.getsinglecustomer(id);
	
		return cu;
		
		
	}
	@PostMapping(value = "/savedoconly/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public  CustomerDocument saveCustDocument(
			@RequestPart (value = "kycProof")MultipartFile kycfile,
	        @RequestPart (value = "itr")MultipartFile itrfile,
	        @RequestPart (value = "aadharCard")MultipartFile aadharfile,
	        @RequestPart (value = "signature")MultipartFile signfile,
	        @RequestPart (value = "bankCheck")MultipartFile bankchqfile,
	        @RequestPart (value = "salarySlip")MultipartFile salfile,
	        @RequestPart (value = "agreement")MultipartFile agreefile,
	        @RequestPart (value = "approvedPlan")MultipartFile apprfile,
	        @RequestPart (value = "photo")MultipartFile photofile,
	        @RequestPart(value="data") String data,
             @PathVariable ("id")int id) throws IOException {

		CustomerDocument cd=new CustomerDocument();
		cd.setKycProof(kycfile.getBytes());
		cd.setAadharCard(aadharfile.getBytes());
		cd.setBankCheck(bankchqfile.getBytes());
		cd.setAgreement(agreefile.getBytes());
		cd.setItr(itrfile.getBytes());
		cd.setPhoto(photofile.getBytes());
		cd.setApprovedPlan(apprfile.getBytes());
		cd.setSalarySlip(salfile.getBytes());
		cd.setSignature(signfile.getBytes());

		ObjectMapper o= new ObjectMapper();
		CustomerDocument custdoc1 =o.readValue(data, CustomerDocument.class);
		
		
		cd.setId(custdoc1.getId());
		cd.setAccNumber(custdoc1.getAccNumber());
		cd.setGuarantorname(custdoc1.getGuarantorname());
		cd.setGuarantormail(custdoc1.getGuarantormail());
		cd.setGuarantoraadharcard(custdoc1.getGuarantoraadharcard());
		cd.setIfsc(custdoc1.getIfsc());
		
		
		cd.setDocStatus("Uploaded");
		cd.setVerfStatus("pending");
		CustomerDocument  custdoc=esi.saveDocumentOnly(cd);

            System.out.println("GitHub Practice");
		
		return custdoc;


	}
        
	@GetMapping(value = "/verifydocument/{id}")
	 public CustomerDocument documentverified(@PathVariable ("id")int id) {

	CustomerDocument  d =	esi.findDocumentId(id);
		d.setId(id);
		d.setDocStatus("Uploaded");
		d.setVerfStatus("Verified");
		CustomerDocument c1=esi.saveDocumentOnly(d);
		return c1;
		
	 }
	
		@GetMapping("/save/{enqId}")
       public void saveCustomer(@PathVariable int enqId) {
    	 Enquiry e =  esi.findEnq(enqId);
    	 
    	 Customer c= new Customer();
    	 
    	
    	c.setCustomerDateOfBirth(e.getDob());
    	c.setCibil(e.getCibil());
    	c.setCustomerEmail(e.getEmail());
    	c.setCibilstatus(e.getCibilstatus());
    	c.setCustomerMobileNumber(e.getMobileNo());
    	c.setCustomerAge(e.getAge());
    	c.setCustomerGender(e.getGender());
    	c.setCustomerName(e.getFirstName()+e.getLastName());
    	c.setCustomerPancard(e.getPancard());
    	c.setCustomerAddress(e.getAddress());
    	c.setCustomerOccupation(e.getOccupation());
    	c.setCustomerQualification(e.getQualification());
    	c.setCustomerAadharNo(e.getAadharNo());
    	
    	CustomerDocument d= new CustomerDocument();
    	
    	d.setDocStatus("Pending");
    	d.setVerfStatus("Pending");
    	
    	Emi em= new Emi();
    	c.setEmidetails(em);
    	
    	c.setCustdoc(d);
    	
    	Customer c1=esi.SaveCustomer(c);
       }
		
		
		@GetMapping("/rejectlist/{enqId}")
	       public void rejectlist(@PathVariable int enqId) {
	    	 Enquiry e =  esi.findEnq(enqId);
	    	 
	    	 Rejectlist c= new Rejectlist();	    	 
	    	
	    	c.setCustomerDateOfBirth(e.getDob());
	    	c.setCibil(e.getCibil());
	    	c.setCustomerEmail(e.getEmail());
	    	c.setCibilstatus(e.getCibilstatus());
	    	c.setCustomerMobileNumber(e.getMobileNo());
	    	c.setCustomerAge(e.getAge());
	    	c.setCustomerGender(e.getGender());
	    	c.setCustomerName(e.getFirstName()+e.getLastName());
	    	c.setCustomerPancard(e.getPancard());
	    	c.setCustomerAddress(e.getAddress());
	    	c.setCustomerOccupation(e.getOccupation());
	    	c.setCustomerQualification(e.getQualification());
	    	c.setCustomerAadharNo(e.getAadharNo());
	    	
	    	
	    	
	    	Rejectlist c1=esi.SaverejectedCustomer(c);
	       }
		
		
		
		@GetMapping("/getAllCust")
		public List<Customer> getAllcust(){
			List<Customer> al=esi.displayAllcustomer();
			return al;
		}
	
		@GetMapping("/getrejectlist")
		public List<Rejectlist> getrejectlist(){
			List<Rejectlist> al=esi.getrejectlist();
			return al;
		}

	
	@PutMapping("/updateCustomer/{id}")
	public Customer  updateCustomer(@RequestBody Customer c,@PathVariable ("id") int id) {

		c.setId(id);

		Customer c1=esi.UpdateCustomer(c);
		return c1;

	}
	
	@PostMapping("/saveEmidetail/{id}")
	 public ResponseEntity<Customer> saveEmidetail(@RequestBody Emi emi, @PathVariable("id")Integer id)
	 {
		
			     
			  Customer cc=esi.getbyid(id);
			  cc.getEmidetails().setEmi(emi.getEmi());
			  cc.getEmidetails().setId(emi.getId());
			  cc.getEmidetails().setLoantenure(emi.getLoantenure());
			  cc.getEmidetails().setTotalamountpayble(emi.getTotalamountpayble());
			  cc.getEmidetails().setTotalinterestpayble(emi.getTotalinterestpayble());
			  cc.getEmidetails().setSanctionedAmount(emi.getSanctionedAmount());
			   cc.getEmidetails().setRequiredamount(emi.getRequiredamount());
			 Customer cust=esi.SaveCustomer(cc);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
				
	 }
	

			
}
		
		
		                                             



