package com.fabiano.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fabiano.domain.Address;
import com.fabiano.domain.User;
import com.fabiano.dto.UserDTO;
import com.fabiano.dto.UserNewDTO;
import com.fabiano.repositories.AddressRepository;
import com.fabiano.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("User not found " + id + "Type " + User.class.getName()));
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional		
	public User insert(User obj) {
		obj.setId(null);
		obj = userRepository.save(obj);
		addressRepository.save(obj.getAddress());
		return obj;
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getCpf(), objDto.getRg(), null, objDto.getIncome());
	}
	
	public User fromDTO(UserNewDTO objDto) {
		User user = new User(null, objDto.getName(), objDto.getEmail(), objDto.getCpf(), objDto.getRg(), bCrypt.encode(objDto.getPassword()), objDto.getIncome());
		Address address = new Address(null, objDto.getCep(), objDto.getStreet(), objDto.getNumber(), objDto.getNeighbourhood(), objDto.getCity(), objDto.getState(),user);
		user.setAddress(address);
		return user;
		
		
	}
}
