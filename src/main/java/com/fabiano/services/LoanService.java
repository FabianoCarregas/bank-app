package com.fabiano.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.domain.Loan;
import com.fabiano.repositories.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	public Loan insert(Loan obj) {
		obj.setId(null);
		return loanRepository.save(obj);
	}
	

}
