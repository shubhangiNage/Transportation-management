package com.cjc.project.Homeloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDocument {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String docStatus;
	private String verfStatus;
	private long accNumber;
	private String guarantorname;
	private long guarantoraadharcard;
	private String guarantormail;
    private String ifsc;
	@Lob
	private byte[]  kycProof;
	@Lob
	private byte[]   itr;
	@Lob
	private byte[]   aadharCard;
	@Lob
	private byte[]   photo;
	@Lob
	private byte[]   signature;
	@Lob
	private byte[]   bankCheck;
	@Lob
	private byte[]   salarySlip;
	@Lob
	private byte[]   agreement;
	@Lob
	private byte[]   approvedPlan;
	 
}
