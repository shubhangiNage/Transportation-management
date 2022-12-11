package com.cjc.project.Homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.Enquiry;
import com.cjc.project.Homeloan.model.MailSender;
import com.cjc.project.Homeloan.serviceimpl.Emailservice;
import com.cjc.project.Homeloan.serviceimpl.EnquiryServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin("*")
@RestController
@RequestMapping("/mail")
public class Emailcontroller {
	@Autowired 
	private Emailservice eser;
	
	@Autowired
	private EnquiryServiceimpl eq;
	
	@Value("${spring.mail.username}")
	
	String fromEmail;
	
	@GetMapping("/send/{id}")
	public String sendEmail(  @PathVariable Integer id) {
		try {
			 System.out.println("ssd");
			 Customer c = eq.findcust(id);
			MailSender es = new MailSender();   
			
			es.setFromEmail(fromEmail); 
			es.setToEmail(c.getCustomerEmail());
			es.setSubject("Submit Your Document");
			es.setTextbody("Dear"+c.getCustomerName()+"your CIBIL Score is"+c.getCibil()+
					"& you are eligibal for next step of loan approval. please submit your Documents");
		
			eser.sendEmail(es);

			return "sent";
		}
		
		catch(Exception e2) {
			e2.printStackTrace();
			return "not sent";
		}
	}
	
	
	
	
	@PostMapping(value = "/emailWithAttachment",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String sendMailWithAttachment(@RequestPart (required = true, value = "attachment") MultipartFile  at, @RequestPart ("email") String e)
	{
		try {
			
			ObjectMapper o=new ObjectMapper();
			MailSender es =o.readValue(e, MailSender.class);
			MailSender em= new MailSender();
			em.setFromEmail(fromEmail);
			
			em.setSubject(es.getSubject());
			
			em.setToEmail(es.getToEmail());
			em.setTextbody("Please sign this Document & Submit it to our officials");
			
			eser.sendAttachment(em,at);
			
			return "Email sent Successfully...!";
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
			return "Email Failed ...!";
		}
		
		
	}
	

}