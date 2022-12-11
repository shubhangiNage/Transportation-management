package com.cjc.project.Homeloan.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.project.Homeloan.model.CustomerDocument;

@Repository
public interface CustDocRepository extends JpaRepository<CustomerDocument, Integer>{

	
	public CustomerDocument findById(int id);
	
}
