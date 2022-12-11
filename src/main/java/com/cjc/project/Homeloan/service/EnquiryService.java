package com.cjc.project.Homeloan.service;

import java.util.List;
import java.util.Optional;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.CustomerDocument;
import com.cjc.project.Homeloan.model.Enquiry;
import com.cjc.project.Homeloan.model.Ledger;
import com.cjc.project.Homeloan.model.Rejectlist;
import com.cjc.project.Homeloan.model.Emi;

public interface EnquiryService {

public	Enquiry saveEnquiry(Enquiry e);

public List<Enquiry> getAllDetails();

public Optional<Enquiry> getSingleDataenq(Integer cid);

public CustomerDocument saveDocuments(CustomerDocument cd);

public Customer SaveCustomer(Customer cus1);

public Integer checkCibil(Integer cid);

public Enquiry findEnq(int enqId);

public List<Customer> displayAllcustomer();

public Customer UpdateCustomer(Customer c);

public CustomerDocument saveDocumentOnly(CustomerDocument cd);

public CustomerDocument findDocumentId(int id);

Customer findcust(int id);

public Emi setemi(Emi e);

public Customer getbyid(Integer id);

public Emi saveEmidetail(Emi emi);

public Customer getsinglecustomer(Integer id);

public Rejectlist SaverejectedCustomer(Rejectlist c);

public List<Rejectlist> getrejectlist();

public Ledger setledgerdeail(Ledger ledger);

public List<Ledger> getledgerdetails();

public void deleteLeadger(Integer id);

public Ledger UpdateLeadger(Ledger l);






}
