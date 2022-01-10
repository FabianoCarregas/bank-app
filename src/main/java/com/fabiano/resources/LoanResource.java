package com.fabiano.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.domain.Loan;
import com.fabiano.domain.User;
import com.fabiano.dto.LoanDetailsDTO;
import com.fabiano.repositories.UserRepository;
import com.fabiano.services.LoanService;


@RestController
@RequestMapping(value = "/loans")
public class LoanResource {
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LoanDetailsDTO>findById(@PathVariable Long id){
		LoanDetailsDTO loan = loanService.findById(id);
		return ResponseEntity.ok().body(loan);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Loan>> findAll() {
		List<Loan> list = loanService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Void> insert(@PathVariable("id") Long id, @RequestBody @Valid Loan obj) {
		obj = loanService.insert(obj);
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		user.getLoans().add(obj);
		userRepository.save(user);
		return null;
		
	}

}
