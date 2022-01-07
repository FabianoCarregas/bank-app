package com.fabiano.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class UserNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	//user
	@NotNull(message = "Name is mandatory")
	@Column(name = "full_name")
	private String name;

	@NotNull(message = "E-mail is mandatory")
	private String email;

	@CPF
	@NotNull(message = "CPF is mandatory")
	@Column(name = "cpf", length = 11)
	private String cpf;
	private String rg;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	private Double income;
	
	//address
	private String cep;
	private String street;
	private String number;
	private String neighbourhood;
	private String city;
	private String state;
	
	public UserNewDTO() {
	
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
