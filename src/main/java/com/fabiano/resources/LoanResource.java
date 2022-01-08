package com.fabiano.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.domain.Loan;
import com.fabiano.services.LoanService;


@RestController
@RequestMapping(value = "/loans")
public class LoanResource {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Loan>findById(@PathVariable Long id){
		Loan loan = loanService.findById(id);
		return ResponseEntity.ok().body(loan);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Loan>> findAll() {
		List<Loan> list = loanService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Loan> insert(@RequestBody @Valid Loan obj) {
	    obj =loanService.insert(obj);
	    return ResponseEntity.ok().body(obj);
	}
	
	

}
