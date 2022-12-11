package com.cjc.project.Homeloan.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.project.Homeloan.model.Customer;


@Repository
public interface Mailrepository extends JpaRepository<Customer, Integer> {

}
