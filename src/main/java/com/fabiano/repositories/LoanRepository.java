package com.fabiano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.domain.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
}
