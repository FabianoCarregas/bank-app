package com.fabiano.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fabiano.domain.Address;
import com.fabiano.domain.Loan;
import com.fabiano.domain.User;
import com.fabiano.enums.UserProfile;
import com.fabiano.repositories.AddressRepository;
import com.fabiano.repositories.LoanRepository;
import com.fabiano.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	private BCryptPasswordEncoder bc;
	
	public void instantiateTestDatabase() throws ParseException {
		
		User user1 = new User(null, "João Dias", "joao@gamil.com", "22989275029", "443330330", bc.encode("123"), 2000.0);
		User user2 = new User(null, "Maria Fernada", "maria@gmail.com", "36309674005","223334443", bc.encode("321"), 3000.0);
		
		user1.addUserProfile(UserProfile.ADMIN);
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		
		Address address1 = new Address(null, "112223334", "Rua das Flores", "12", "Jardim Vitorias", "Campinas", "SP", user2);
		Address address2 = new Address(null, "117575994", "Rua das betanias", "555", "Jardim Amoreiras", "Uberlandia", "MG", user1);
		
		user1.setAddress(address2);
		user2.setAddress(address1);
	
		addressRepository.save(address1);
		addressRepository.save(address2);
		
		Loan loan1 = new Loan(null, 1222, "12/12/21", 12, user2);
		Loan loan2 = new Loan(null, 2000, "20/12/21", 24, user1);
		
		loanRepository.save(loan1);
		loanRepository.save(loan2);
		
		user1.getLoans().add(loan1);
		user2.getLoans().add(loan2);
				
		
		
	}

}
