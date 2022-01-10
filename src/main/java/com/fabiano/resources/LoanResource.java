package com.fabiano.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.domain.Loan;
import com.fabiano.dto.LoanDetailsDTO;
import com.fabiano.services.LoanService;


@RestController
@RequestMapping(value = "/loans")
public class LoanResource {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LoanDetailsDTO>findById(@PathVariable Long id){
		LoanDetailsDTO loan = loanService.findById(id);
		return ResponseEntity.ok().body(loan);
	}
	
	@PostMapping
	public ResponseEntity<Loan> insert(@RequestBody Loan obj) {
	    obj =loanService.insert(obj);
	    return ResponseEntity.ok().body(obj);
	}

}
