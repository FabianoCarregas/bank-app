package com.fabiano.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.domain.Loan;
import com.fabiano.domain.User;
import com.fabiano.dto.LoanDetailsDTO;
import com.fabiano.enums.LoanStatus;
import com.fabiano.enums.UserProfile;
import com.fabiano.repositories.LoanRepository;
import com.fabiano.repositories.UserRepository;
import com.fabiano.security.UserSS;
import com.fabiano.services.exceptions.AuthorizationException;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	UserRepository userRepository;

	public LoanDetailsDTO findById(Long id) {
		
		UserSS user = UsersService.authenticated();
		if (user==null || !user.hasRole(UserProfile.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("You do not have permission to access this content");
		}
		
		Optional<Loan> obj = loanRepository.findById(id);
		LoanDetailsDTO loanDto = new LoanDetailsDTO();
		if(obj.isPresent()) {
			loanDto.setId(obj.get().getId());
			loanDto.setLoanValue(obj.get().getLoanValue());
			loanDto.setInstallments(obj.get().getInstallments());
		    loanDto.setFirstInstallment(obj.get().getFirstInstallment());
		    loanDto.setEmail(obj.get().getUser().getEmail());
			loanDto.setUserIncome(obj.get().getUser().getIncome());
			loanDto.setStatus(obj.get().getStatus());
			
			return loanDto;
		}
		 return null;
	}		
	
	public List<Loan> findAll() {
		return loanRepository.findAll();	
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
		return null;
	}
	
	public Date validDate() {
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.MONTH, 3);
		Date date = cal.getTime();
		return date;
	}
	
}
