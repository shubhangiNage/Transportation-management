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
public class Rejectlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer	id;
private String	customerName;
private String	customerDateOfBirth;
private  Integer customerAge;
private String  customerGender;
private String  customerEmail;
private double	customerMobileNumber;
private Integer cibil;
private String cibilstatus;
private double customerAmountPaidForHome;
private double customerTotalLoanRequired;
private String customerPancard;
private String customerAddress;
private String customerOccupation;
private String customerQualification;
private Long customerAadharNo;

}
