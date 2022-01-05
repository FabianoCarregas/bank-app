package com.fabiano.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @NotNull
    private Long loanValue;

    @NotNull
    private String firstInstallment;

    @Min(value = 3, message = "Must be equal or greatter than 3 installments")
    @Max(value = 60, message = "Most be equal or less than 60 installments")
    @NotNull
    private Integer Installments;

    public Loan() {
	}

	public Loan(Long id, @NotNull Long loanValue, @NotNull String firstInstallment,
			@Min(value = 3, message = "Must be equal or greatter than 3 installments") @Max(value = 60, message = "Most be equal or less than 60 installments") @NotNull Integer installments) {
		super();
		this.id = id;
		this.loanValue = loanValue;
		this.firstInstallment = firstInstallment;
		Installments = installments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstInstallment() {
		return firstInstallment;
	}

	public void setFirstInstallment(String firstInstallment) {
		this.firstInstallment = firstInstallment;
	}

	public Integer getInstallments() {
		return Installments;
	}

	public void setInstallments(Integer installments) {
		Installments = installments;
	}

	public Long getLoanValue() {
		return loanValue;
	}

	public void setLoanValue(Long loanValue) {
		this.loanValue = loanValue;
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
		Loan other = (Loan) obj;
		return Objects.equals(id, other.id);
	}   
    
}
