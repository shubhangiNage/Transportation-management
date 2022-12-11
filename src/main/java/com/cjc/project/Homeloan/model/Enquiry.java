package com.cjc.project.Homeloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String firstName;
private String lastName;
private String gender;
private String dob;
private Integer age;
private String email;
private Double mobileNo;
private String pancard;
private String address;
private String occupation;
private String qualification;
private Long aadharNo;
private Integer cibil;
private String cibilstatus;



	
	

}
