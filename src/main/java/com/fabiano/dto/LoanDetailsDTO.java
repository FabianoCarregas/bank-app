package com.fabiano.dto;

import java.util.Date;

import com.fabiano.enums.LoanStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanDetailsDTO {

	private Long id;
	
	@JsonProperty("Loan Amount")
    private Integer loanValue;				
    private Integer Installments;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("First installment date")
    private Date firstInstallment;
    
    @JsonProperty("User e-mail")
    private String email;
    
    @JsonProperty("User income")
    private Double userIncome;			
    
    @JsonProperty("Loan Status")
    private LoanStatus status;
    
    public LoanDetailsDTO() {
    }

	public LoanDetailsDTO(Long id, Integer loanValue, Integer installments, Date firstInstallment, String email,
			Double userIncome, LoanStatus status) {
		super();
		this.id = id;
		this.loanValue = loanValue;
		this.Installments = installments;
		this.firstInstallment = firstInstallment;
		this.email = email;
		this.userIncome = userIncome;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLoanValue() {
		return loanValue;
	}

	public void setLoanValue(Integer loanValue) {
		this.loanValue = loanValue;
	}

	public Integer getInstallments() {
		return Installments;
	}

	public void setInstallments(Integer installments) {
		Installments = installments;
	}

	public Date getFirstInstallment() {
		return firstInstallment;
	}

	public void setFirstInstallment(Date firstInstallment) {
		this.firstInstallment = firstInstallment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getUserIncome() {
		return userIncome;
	}

	public void setUserIncome(Double userIncome) {
		this.userIncome = userIncome;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

}
