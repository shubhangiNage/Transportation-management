package com.cjc.project.Homeloan.serviceimpl;



import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.Enquiry;
import com.cjc.project.Homeloan.model.MailSender;
import com.cjc.project.Homeloan.repositary.CustomerRepository;
import com.cjc.project.Homeloan.repositary.EnquiryRepository;


@Service
public class Emailservice {
	
	
	
@Autowired private JavaMailSender jms;
	
	public void sendEmail(MailSender e) {
		try {
	
		SimpleMailMessage smm=new SimpleMailMessage();
		
		
		smm.setFrom(e.getFromEmail());
		smm.setTo(e.getToEmail());
		smm.setSubject(e.getSubject());
		smm.setText(e.getTextbody());
		
		System.out.println(smm.getTo());
		
		jms.send(smm);
		System.out.println("Mail Sent Successfully...!");
	}
	catch(Exception e2) {
		
		System.out.println("Not Sent");
		e2.printStackTrace();
		
		
	}
	}
		
		public void sendAttachment(MailSender em, MultipartFile at) throws MessagingException {
			
			try {
				
				MimeMessage mm= jms.createMimeMessage();
				MimeMessageHelper mmh= new MimeMessageHelper(mm,true);
				
				mmh.setFrom(em.getFromEmail());
				mmh.setTo(em.getToEmail());
				mmh.setText(em.getTextbody());
				mmh.setSubject(em.getSubject());
				mmh.addAttachment(at.getOriginalFilename(), at);
				jms.send(mm);
				
				System.out.println("Email sent");
				
			} catch (Exception e) {
				
				System.out.println("Not sent");
				e.printStackTrace();
			}
			
		}
		
	


}