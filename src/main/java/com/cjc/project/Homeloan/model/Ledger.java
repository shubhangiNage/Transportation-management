package com.cjc.project.Homeloan.model;

import java.util.Date;

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
public class Ledger {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer ledgerId;
private String CustomerName;
private Integer  totalLoanAmount;
private  Integer payableAmount;
private Integer  payableAmountwithIntrest;
private Integer  tenureInYear;
private  Integer monthlyEMI;
private  Date  amountPaidTillDate;
private Integer remainingAmount;
private Integer deafaulterCount;
private  String previousEmiStatus;
private  String currentMonthEmiStatus;
private Date  loanEnddate;
private String  loanstatus;
}