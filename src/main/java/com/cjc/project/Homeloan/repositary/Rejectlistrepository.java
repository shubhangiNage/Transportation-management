package com.cjc.project.Homeloan.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.project.Homeloan.model.Rejectlist;

@Repository
public interface Rejectlistrepository extends JpaRepository<Rejectlist, Integer> {

	Rejectlist save(Rejectlist c);

}
