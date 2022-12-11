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
public class Emi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	  private long emi;
	  private long totalinterestpayble;
	  private long loantenure;
	  private long totalamountpayble;
	  private long sanctionedAmount;
	  private long requiredamount;
}
