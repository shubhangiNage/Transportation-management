package com.cjc.project.Homeloan.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.CustomerDocument;
import com.cjc.project.Homeloan.model.Enquiry;
import com.cjc.project.Homeloan.model.Ledger;
import com.cjc.project.Homeloan.model.Rejectlist;
import com.cjc.project.Homeloan.model.Emi;
import com.cjc.project.Homeloan.repositary.CustDocRepository;
import com.cjc.project.Homeloan.repositary.CustomerRepository;
import com.cjc.project.Homeloan.repositary.Emirepository;
import com.cjc.project.Homeloan.repositary.EnquiryRepository;
import com.cjc.project.Homeloan.repositary.LedgerRepository;
import com.cjc.project.Homeloan.repositary.Rejectlistrepository;
import com.cjc.project.Homeloan.service.EnquiryService;


@Service
public class EnquiryServiceimpl implements EnquiryService{
	
	@Autowired
private	EnquiryRepository er;
	
	@Autowired
	private CustDocRepository cdr;
	
	@Autowired
	private Emirepository emir;
	
	@Autowired
	private CustomerRepository cr;

	@Autowired
	private Rejectlistrepository rr;
	@Autowired
	private LedgerRepository ledgerrepo;
	
	
	@Override
	public Enquiry saveEnquiry(Enquiry e) {
		
		return er.save(e);
	}

	@Override
	public List<Enquiry> getAllDetails() {
	
		return er.findAll();
	}

	@Override
	public Optional<Enquiry> getSingleDataenq(Integer cid) {
		
		return er.findById(cid);
	}

	@Override
	public CustomerDocument saveDocuments(CustomerDocument cd) {
	
		return cdr.save(cd);
		
	}

	@Override
	public Customer SaveCustomer(Customer cus1) {
	
		return cr.save(cus1);
	}

	@Override
	public Integer checkCibil(Integer cid) {
		Integer min=300;
		Integer max=900;
		Integer b=(int) (Math.random()*(max-min+1)+min);
		if(b>750) {
			
			Optional<Enquiry> data=er.findById(cid);
			if(data.isPresent()) {
				
				Enquiry enq=data.get();
				enq.setCibil(b);
				enq.setCibilstatus("Approved");
				er.save(enq);
			}
			return b;
		}
		else {
			Optional<Enquiry> data=er.findById(cid);
			if(data.isPresent()) {
				Enquiry enq=data.get();
				enq.setCibil(b);
				enq.setCibilstatus("Rejected");
				er.save(enq);
				
			}
			return b;
		}
	}

	@Override
	public Enquiry findEnq(int enqId) {
		
	Enquiry e=	er.findAllById(enqId);
	
		return   e;
	}

	@Override
	public List<Customer> displayAllcustomer() {
	
		return  cr.findAll();
	}

	@Override
	public Customer UpdateCustomer(Customer c) {
		
		return cr.save(c);
	}

	@Override
	public CustomerDocument saveDocumentOnly(CustomerDocument cd) {
		
		return cdr.save(cd);
	}

	@Override
	public CustomerDocument findDocumentId(int id) {
		
		return   cdr.findById(id);
	}

	@Override
	public Customer findcust(int custid) {
		
	Customer c=	cr.findAllById(custid);
	
		return   c;
	}

	@Override
	public Emi setemi(Emi e) {
		
		Emi d =emir.save(e) ;
		return d;
	}

	@Override
	public Customer getbyid(Integer id) {
	
		
			return cr.getById(id);
	
	}

	@Override
	public Emi saveEmidetail(Emi emi) {
		// TODO Auto-generated method stub
		return emir.save(emi);
	}

	@Override
	public Customer getsinglecustomer(Integer id) {
		
		
			Customer cd=cr.findAllById(id);
			return cd;
	}

	@Override
	public Rejectlist SaverejectedCustomer(Rejectlist c) {
	
		return rr.save(c);
	}

	@Override
	public List<Rejectlist> getrejectlist() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public Ledger setledgerdeail(Ledger ledger) {
	    
		return ledgerrepo.save(ledger);
	}

	@Override
	public List<Ledger> getledgerdetails() {
		
		return ledgerrepo.findAll();
	}

	@Override
	public void deleteLeadger(Integer id) {
		
		ledgerrepo.deleteById(id);
	}

	@Override
	public Ledger UpdateLeadger(Ledger l) {
		
		return  ledgerrepo.save(l);
	}
	

}
