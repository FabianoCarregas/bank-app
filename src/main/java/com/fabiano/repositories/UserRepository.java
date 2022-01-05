package com.fabiano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	

}