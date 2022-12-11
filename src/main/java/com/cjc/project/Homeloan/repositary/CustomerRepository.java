package com.cjc.project.Homeloan.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.project.Homeloan.model.Customer;
import com.cjc.project.Homeloan.model.CustomerDocument;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findAllById(int id);

	

}
