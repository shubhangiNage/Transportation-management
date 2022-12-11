package com.cjc.project.Homeloan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MailSender {
	
	
	private Integer id;
	private String fromEmail;
	private String toEmail;
	private String textbody;
	private String subject;
	

	private String customername;
	
	

	
}