package com.fabiano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
