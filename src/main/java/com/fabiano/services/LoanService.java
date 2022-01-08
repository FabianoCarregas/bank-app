package com.fabiano.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.domain.Loan;
import com.fabiano.enums.LoanStatus;
import com.fabiano.enums.UserProfile;
import com.fabiano.exceptions.AuthorizationException;
import com.fabiano.repositories.LoanRepository;
import com.fabiano.security.UserSS;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	
	
	public Loan findById(Long id) {
		
		UserSS user = UsersService.authenticated();
		if (user==null || !user.hasRole(UserProfile.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("You do not have permission to access this content");
		}
		
		Optional<Loan> obj = loanRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Loan.class.getName(), null));
		
	}
	
	public List<Loan>findAll() {
		return loanRepository.findAll();		
	}
	
	public Date validDate() {
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.MONTH, 3);
		Date date = cal.getTime();
		return date;
		}
	
	
	public Loan insert(Loan obj) {
		obj.setId(null);
		obj.setLoanValue(obj.getLoanValue());
		Date date = obj.getFirstInstallment();
		if (date.before(this.validDate()) ) {
			obj.setStatus(LoanStatus.APPROVED);
		} else {
			obj.setStatus(LoanStatus.DENIED);
		}
		
		loanRepository.save(obj);
		return obj;
		
		
	}
	
	
		
}
	
	

