package com.fabiano.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fabiano.enums.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private String rg;
	
	@JsonIgnore
	private String password;
	private Double income;
	
	@OneToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

 	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();
 	
 	@ElementCollection(fetch = FetchType.EAGER)
 	@CollectionTable(name = "PROFILES")
 	private Set<Integer> profiles = new HashSet<>();
	
	public User() {
		addUserProfile(UserProfile.CLIENT);
	}

	public User(Long id, String name, String email, String cpf, String rg, String password, Double income) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.password = password;
		this.income = income;
		addUserProfile(UserProfile.CLIENT);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	public Set<UserProfile> getProfiles() {
		return profiles.stream().map(x -> UserProfile.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addUserProfile(UserProfile profile) {
		profiles.add(profile.getCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
