package com.fabiano.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fabiano.enums.LoanStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_loan")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("Loan Code")
	private Long id;
    private Integer loanValue;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date firstInstallment;
    
    @Min(value = 2, message = "Must be equal or greatter than 2 installments")
    @Max(value = 60, message = "Most be equal or less than 60 installments")
    private Integer Installments;
    
    @JsonIgnore
    private LoanStatus status; 
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Loan() {
	}

	public Loan(Long id, Integer loanValue, Date firstInstallment,
			Integer installments, LoanStatus status, User user) {
		super();
		this.id = id;
		this.loanValue = loanValue;
		this.firstInstallment = firstInstallment;
		this.Installments = installments;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFirstInstallment() {
		return firstInstallment;
	}

	public void setFirstInstallment(Date firstInstallment) {
		this.firstInstallment = firstInstallment;
	}

	public Integer getInstallments() {
		return Installments;
	}

	public void setInstallments(Integer installments) {
		Installments = installments;
	}

	public Integer getLoanValue() {
		return loanValue;
	}

	public void setLoanValue(Integer loanValue) {
		this.loanValue = loanValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
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
