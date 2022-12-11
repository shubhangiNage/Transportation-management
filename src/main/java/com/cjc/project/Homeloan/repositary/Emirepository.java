package com.cjc.project.Homeloan.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.project.Homeloan.model.Emi;

@Repository
public interface Emirepository extends JpaRepository<Emi, Integer>{

	Emi save(Emi e);

}
